package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.User;

public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userGender;
    private String userAge;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.userGender = user.getUserGender();
        this.userAge = user.getUserAge();
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    
}
