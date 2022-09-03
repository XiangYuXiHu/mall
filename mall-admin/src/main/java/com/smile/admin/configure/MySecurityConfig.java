package com.smile.admin.configure;

import com.smile.admin.service.ResourceService;
import com.smile.admin.service.UserService;
import com.smile.dao.entity.Resource;
import com.smile.security.basic.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @ClassName MySecurityConfig
 * @Author smile
 * @date 2022.07.16 23:14
 */
@Configuration
public class MySecurityConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    /**
     * 核心接口，用于根据用户名获取用户信息，需要自行实现
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Resource> resourceList = resourceService.list();
                for (Resource resource : resourceList) {
                    map.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }


}
