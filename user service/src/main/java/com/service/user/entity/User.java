package com.service.user.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field(name = "user-name")
    private String userName;

    @Field(name = "password")
    private String password;

    @Field(name = "role")
    private String role;
}
