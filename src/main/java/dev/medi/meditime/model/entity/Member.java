package dev.medi.meditime.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Builder
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate regDate;

    public Member() {}


    @Builder
    public Member(Long memberId, String email, String password, String born, String gender, LocalDate regDate) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.born = born;
        this.gender = gender;
        this.regDate = regDate;
    }
}
