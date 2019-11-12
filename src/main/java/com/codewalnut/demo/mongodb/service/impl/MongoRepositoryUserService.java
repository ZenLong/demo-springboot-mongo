package com.codewalnut.demo.mongodb.service.impl;

import com.codewalnut.demo.mongodb.domain.User;
import com.codewalnut.demo.mongodb.repository.UserRepository;
import com.codewalnut.demo.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户服务Repository实现类
 *
 * @author KelvinZ
 * @date 2019-11-12 12:40
 */
@Service
public class MongoRepositoryUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        user.setCtime(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findByNameRegex(name);
    }

}
