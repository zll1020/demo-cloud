package com.example.cloud.democloud.controller;

import com.example.cloud.democloud.dao.UserRespository;
import com.example.cloud.democloud.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 11:00
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = this.userRespository.getOne(id);
        return user;
    }

    @GetMapping("/security/{id}")
    public User findByIdSecurity(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
            for (GrantedAuthority authority : collection){
                log.info("当前用户是：{},角色是：{}",userDetails.getUsername(),authority.getAuthority());
            }
        }else {
            log.info("else");
        }
        User user = userRespository.getOne(id);
        return user;
    }
}
