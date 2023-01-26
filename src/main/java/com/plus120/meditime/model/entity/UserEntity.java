package com.plus120.meditime.model.entity;

import com.plus120.meditime.model.AuditingFields;
import com.plus120.meditime.model.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class UserEntity extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Column(nullable = false, length = 50) private String userName;
    @Setter @Column(nullable = false) private String password;
    @Column(name = "role") @Enumerated(EnumType.STRING) private UserRole role = UserRole.USER;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickname;

    protected UserEntity() {}

    private UserEntity(String userName, String password, String email, String nickname) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    // new Entity
    public static UserEntity of(String userName, String password, String email, String nickname) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setNickname(nickname);

        return userEntity;
    }


}
