package dev.medi.meditime.model.entity;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Getter
@Table(name="USERS")
@DynamicUpdate
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long memberId;

    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="born", nullable = false)
    private String born;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="reg_date", nullable = false)
    private Date regDate;

    public Member() {}


}
