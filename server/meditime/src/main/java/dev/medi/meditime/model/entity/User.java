package dev.medi.meditime.model.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Getter @Setter
@Builder
@Table(name="USERS")
@DynamicUpdate
public class User {

    @Id
    @Column(name="user_id")
    private String userId;
    
    @Column(name="user_pw", nullable = false)
    private String userPw;

    @Column(name="user_email", nullable = false)
    private String userEmail;

    @Column(name="user_born", nullable = false)
    private String userBorn;

    @Column(name="user_gender", nullable = false)
    private String userGender;

    @Column(name="reg_date", nullable = false)
    private Date regDate;

    public User() {}

    public User(String userId) {
        this.userId = userId;
    }

    public void updateId(String userId) {
        this.userId = userId;
    }

    @Builder
    public User(String userId, String userPw, String userEmail, String userBorn, String userGender, Date regDate) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userBorn = userBorn;
        this.userGender = userGender;
        this.regDate = regDate;
    }
}
