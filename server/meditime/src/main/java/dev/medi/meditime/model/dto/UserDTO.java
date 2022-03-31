package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.User;

public class UserDTO {
    private String userId;
    private String userPw;
    private String userEmail;
    private String userBorn;
    private String userGender;
    private String regDate;

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

    //
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBorn() {
        return userBorn;
    }

    public void setUserBorn(String userBorn) {
        this.userBorn = userBorn;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    
}
