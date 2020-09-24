package com.codewalnut.demo.mongodb.web.controller;

import com.codewalnut.demo.mongodb.domain.User;
import com.codewalnut.demo.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 *
 * @author KelvinZ
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
//    @Qualifier("mongoTemplateUserService")
    @Qualifier("mongoRepositoryUserService")
    private UserService userService;

    @RequestMapping("/create")
    public User createUser(String name) {
        return userService.createUser(name);
    }

    @RequestMapping("/findByName")
    public List<User> findUserByName(String name) {
        return userService.findUserByName(name);
    }

}
