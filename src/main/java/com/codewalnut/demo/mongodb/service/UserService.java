package com.codewalnut.demo.mongodb.service;

import com.codewalnut.demo.mongodb.domain.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author KelvinZ
 * @date 2019-11-12 12:45
 */
public interface UserService {
    /**
     * 创建用户
     *
     * @param name
     * @return
     */
    User createUser(String name);

    /**
     * 根据用户名查找用户
     *
     * @param name
     * @return
     */
    List<User> findUserByName(String name);
}
