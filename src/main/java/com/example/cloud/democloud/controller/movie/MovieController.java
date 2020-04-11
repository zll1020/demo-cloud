package com.example.cloud.democloud.controller.movie;

import com.example.cloud.democloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 11:12
 */
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(("/getUser/{id}"))
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8000/user/" + id,User.class);
    }
}
