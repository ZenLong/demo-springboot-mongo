package com.codewalnut.demo.mongodb.service;

import com.codewalnut.demo.mongodb.domain.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author KelvinZ
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param name name of user
     * @return User
     */
    User createUser(String name);

    /**
     * 根据用户名查找用户
     *
     * @param name name of user
     * @return User list
     */
    List<User> findUserByName(String name);
}
