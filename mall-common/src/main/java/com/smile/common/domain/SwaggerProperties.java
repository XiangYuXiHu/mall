package com.smile.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @ClassName SwaggerProperties
 * @Author smile
 * @date 2022.07.03 15:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerProperties {

    /**
     * api文档生成基础路径
     */
    private String apiBasePackage;

    /**
     * 是否要启用登录认证
     */
    private boolean enableSecurity;

    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档描述
     */
    private String description;

    /**
     * 文档版本
     */
    private String version;

    /**
     * 文档联系人
     */
    private String contactName;

    /**
     * 文档联系人网址
     */
    private String contactUrl;

    /**
     * 文档联系人邮箱
     */
    private String contactEmail;
}
