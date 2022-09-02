package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class UserDTO {
    private String userId;
    private String userPw;
    private String userEmail;
    private String userBorn;
    private String userGender;
    private Date regDate;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userEmail = user.getUserEmail();
        this.userGender = user.getUserGender();
        this.userBorn = user.getUserBorn();
        this.regDate = user.getRegDate();
    }

    public UserDTO() {};

    public UserDTO(String userId) {
        this.userId = userId;
    };

    public UserDTO(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

    public UserDTO(String userId, String userPw, String userEmail, String userBorn, String userGender, Date regDate) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userBorn = userBorn;
        this.userGender = userGender;
        this.regDate = regDate;
    }
}
