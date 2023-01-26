package com.plus120.meditime.controller.response;

import com.plus120.meditime.model.User;
import com.plus120.meditime.model.UserRole;
import lombok.Getter;

@Getter
public class UserJoinResponse {
    private Integer id;
    private String userName;
    private UserRole role;

    private UserJoinResponse(Integer id, String userName, UserRole role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

    public static UserJoinResponse fromUser(User user) {
       return new UserJoinResponse(
               user.getId(),
               user.getUserName(),
               user.getUserRole()
       );
    }
}
