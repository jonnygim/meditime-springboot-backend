package com.plus120.meditime.controller.request;

import lombok.Getter;

@Getter
public class UserJoinRequest {
    private String userName;
    private String userPassword;
    private String email;
    private String nickname;

    public UserJoinRequest() {}

    private UserJoinRequest(String userName, String userPassword, String email, String nickname) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
    }

    public static UserJoinRequest of(String userName, String userPassword, String email, String nickname) {
        return new UserJoinRequest(
                userName,
                userPassword,
                email,
                nickname
        );
    }
}
