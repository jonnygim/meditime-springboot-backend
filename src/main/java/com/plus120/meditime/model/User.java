package com.plus120.meditime.model;

import com.plus120.meditime.model.entity.UserEntity;
import lombok.Getter;

@Getter
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private UserRole userRole;

    public User() {}

    private User(Integer id, String userName, String password, String email, String nickname, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.userRole = userRole;
    }


    public static User fromEntity(UserEntity entity) {
        return new User(
            entity.getId(),
                entity.getUserName(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getRole()
        );
    }

}
