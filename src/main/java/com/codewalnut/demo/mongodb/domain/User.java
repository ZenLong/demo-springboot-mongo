package com.codewalnut.demo.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 用户类
 *
 * @author KelvinZ
 * @date 2019-11-12 12:32
 */

@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field("name")
    @Indexed(unique = true, background = true)
    private String name;

    @Field("ctime")
    @Indexed(direction = IndexDirection.DESCENDING, background = true)
    private Date ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

}
