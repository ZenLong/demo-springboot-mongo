package com.codewalnut.demo.mongodb.repository;

import com.codewalnut.demo.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 用户存储类
 *
 * @author KelvinZ
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameRegex(String name);

}
