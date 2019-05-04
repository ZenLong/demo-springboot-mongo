package com.codewalnut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MongoDb测试
 *
 * @author KelvinZ
 * @date 2019-05-05 12:10
 */
@SpringBootApplication
public class MongoDbApplication {
	private static Logger log = LoggerFactory.getLogger(MongoDbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}
}
