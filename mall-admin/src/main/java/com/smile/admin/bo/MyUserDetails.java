package com.smile.admin.bo;

import com.smile.dao.entity.Resource;
import com.smile.dao.entity.User;
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
    private User user;
    /**
     * 资源列表
     */
    private List<Resource> resourceList;

    public MyUserDetails(User user, List<Resource> resourceList) {
        this.user = user;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream().map(resource ->
                new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.getStatus().equals(1);
    }
}
