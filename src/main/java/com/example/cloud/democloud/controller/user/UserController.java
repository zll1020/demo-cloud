package com.example.cloud.democloud.controller.user;

import com.example.cloud.democloud.dao.UserRespository;
import com.example.cloud.democloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 11:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = this.userRespository.getOne(id);
        return user;
    }
}
