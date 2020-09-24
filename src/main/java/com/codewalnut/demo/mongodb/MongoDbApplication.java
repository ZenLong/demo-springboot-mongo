package com.codewalnut.demo.mongodb;

import com.codewalnut.demo.mongodb.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * MongoDb测试
 *
 * @author KelvinZ
 */
@SpringBootApplication
@PropertySource(value = "classpath:application-mongodb.properties", encoding = "utf-8")
public class MongoDbApplication {
    private Logger log = LoggerFactory.getLogger(MongoDbApplication.class);

    @EventListener(ApplicationReadyEvent.class)
    public void handleEvent(ApplicationReadyEvent event) {
        log.info("系统启动完成 {}", event);
        MongoTemplate mongoTemplate = event.getApplicationContext().getBean(MongoTemplate.class);
        MongoMappingContext mongoMappingContext = event.getApplicationContext().getBean(MongoMappingContext.class);

        IndexOperations indexOps = mongoTemplate.indexOps(User.class);
        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
        resolver.resolveIndexFor(User.class).forEach(indexOps::ensureIndex);
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

}
