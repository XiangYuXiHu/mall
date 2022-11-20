package com.smile.admin.configure;

import com.smile.common.config.BaseSwaggerConfig;
import com.smile.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置
 *
 * @Description
 * @ClassName SwaggerConfig
 * @Author smile
 * @date 2022.07.03 15:21
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig extends BaseSwaggerConfig {

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.smile.admin.controller")
                .title("Mall Manager")
                .description("Mall Manager API Document")
                .contactName("Smile")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
