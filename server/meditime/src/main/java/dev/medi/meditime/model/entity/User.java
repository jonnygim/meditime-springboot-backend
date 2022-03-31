package dev.medi.meditime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="USERS")
@DynamicUpdate
public class User {

    @Id
    @Column(name="user_id")
    private String userId;
    
    @Column(name="user_pw")
    private String userPw;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_born")
    private String userBorn;

    @Column(name="user_gender")
    private String userGender;

    @Column(name="reg_date")
    private String regDate;

    public User() {};

    public User(String userId) {
        this.userId = userId;
    }


    public void updateId(String userId) {
        this.userId = userId;
    }

    ////
    public String getUserId() {
        return userId;
    }

    


    //
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
