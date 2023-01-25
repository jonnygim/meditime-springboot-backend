package com.plus120.meditime.model;

import lombok.Getter;

@Getter
public class User {
    private String userId;
    private String password;
    private String email;
    private String nickname;

    public User() {}

    public User(String userId, String password, String email, String nickname) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }
}
