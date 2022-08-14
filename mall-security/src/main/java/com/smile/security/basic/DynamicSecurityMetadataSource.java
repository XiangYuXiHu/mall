package com.smile.security.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 动态权限数据源，用于获取动态权限规则
 *
 * @Description
 * @ClassName DynamicSecurityMetadataSource
 * @Author smile
 * @date 2022.07.17 20:09
 */
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, ConfigAttribute> configAttributeMap = null;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (configAttributeMap == null) {
            loadDataSource();
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        String url = ((FilterInvocation) object).getRequestUrl();
        try {
            String path = new URI(url.trim()).getPath();
            AntPathMatcher pathMatcher = new AntPathMatcher();
            Iterator<String> iterator = configAttributeMap.keySet().iterator();
            while (iterator.hasNext()) {
                String pattern = iterator.next();
                if (pathMatcher.match(pattern, path)) {
                    configAttributes.add(configAttributeMap.get(pattern));
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
