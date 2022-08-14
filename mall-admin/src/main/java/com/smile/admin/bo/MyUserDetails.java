package com.smile.admin.bo;

import com.smile.dao.entity.UmsResource;
import com.smile.dao.entity.UmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @ClassName MyUserDetails
 * @Author smile
 * @date 2022.07.16 23:23
 */
public class MyUserDetails implements UserDetails {

    /**
     * 后台用户
     */
    private UmsUser umsUser;
    /**
     * 资源列表
     */
    private List<UmsResource> resourceList;

    public MyUserDetails(UmsUser umsUser, List<UmsResource> resourceList) {
        this.umsUser = umsUser;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream().map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsUser.getPassword();
    }

    @Override
    public String getUsername() {
        return umsUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsUser.getStatus().equals(1);
    }
}
