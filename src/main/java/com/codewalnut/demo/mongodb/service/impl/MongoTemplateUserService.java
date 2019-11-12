package com.codewalnut.demo.mongodb.service.impl;

import com.codewalnut.demo.mongodb.domain.User;
import com.codewalnut.demo.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户服务MongoTemplate实现类
 *
 * @author KelvinZ
 * @date 2019-11-12 12:33
 */
@Service
public class MongoTemplateUserService implements UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        user.setCtime(new Date());
        return mongoTemplate.insert(user);
    }

    @Override
    public List<User> findUserByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name));
        return mongoTemplate.find(query, User.class);
    }
}
