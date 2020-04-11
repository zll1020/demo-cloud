package com.example.cloud.democloud.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 17:00
 */
@Data
public class SecurityUser implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private String role;

    public SecurityUser(String username ,String password,String role) {
        super();
        this.username=username;
        this.password=password;
        this.role=role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
        ((ArrayList<GrantedAuthority>) authorities).add(authority);
        return authorities;
    }

    public SecurityUser() {
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
        return true;
    }
}
