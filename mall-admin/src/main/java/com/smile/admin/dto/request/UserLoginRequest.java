package com.smile.admin.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Description
 * @ClassName UmsUserLoginParam
 * @Author smile
 * @date 2022.08.09 20:36
 */
@Getter
@Setter
public class UserLoginRequest implements Serializable {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @Override
    public String toString() {
        return "AdminLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
