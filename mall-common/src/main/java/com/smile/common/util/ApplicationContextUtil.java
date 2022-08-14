package com.smile.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 *
 * @Description
 * @ClassName ApplicationContextUtil
 * @Author smile
 * @date 2022.07.16 15:43
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 根据beanName获取Bean
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 根据className获取Beam
     *
     * @param clazzName
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazzName) {
        return getApplicationContext().getBean(clazzName);
    }

    /**
     * 根据beanName与clazzName获取bean
     *
     * @param beanName
     * @param clazzName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> clazzName) {
        return getApplicationContext().getBean(beanName, clazzName);
    }
}
