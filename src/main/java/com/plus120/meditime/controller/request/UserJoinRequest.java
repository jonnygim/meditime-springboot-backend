package com.plus120.meditime.controller.request;

import lombok.Getter;

@Getter
public class UserJoinRequest {
    private String userId;
    private String userPassword;
    private String email;
    private String nickname;

    public UserJoinRequest() {}

    private UserJoinRequest(String userId, String userPassword, String email, String nickname) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
    }

    public static UserJoinRequest of(String userId, String userPassword, String email, String nickname) {
        return new UserJoinRequest(
                userId,
                userPassword,
                email,
                nickname
        );
    }
}
