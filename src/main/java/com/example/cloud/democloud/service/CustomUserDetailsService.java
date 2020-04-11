package com.example.cloud.democloud.service;

import com.example.cloud.democloud.entity.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 16:59
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    /**
     * 模拟两个账户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)){
            return new SecurityUser("user","password1","user-role");
        }else if ("admin".equals(username)){
            return new SecurityUser("admin","password2","user-admin");
        }else {
            return null;
        }
    }
}
