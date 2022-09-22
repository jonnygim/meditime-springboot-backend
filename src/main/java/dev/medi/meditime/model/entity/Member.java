package dev.medi.meditime.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.medi.meditime.model.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Builder
@Table(name="MEMBERS")
@DynamicUpdate
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long memberId;

    @Column(unique = true)
    private String username;

    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String nickName;

    @Column(name="born", nullable = false)
    private String born;

    @Column(name="gender", nullable = false)
    private String gender;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private Set<Authority> authorities = new HashSet<>();

    @Column(name="reg_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate regDate;

    public Member() {}

    public void updateName(String name) {
        this.name = name;
    }


    @Builder
    public Member(Long memberId, String email, String password, String name, String born, String gender, LocalDate regDate) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.regDate = regDate;
    }

    public static Member ofUser(MemberDTO memberDTO) {
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email()
                .password()
                .nickName()
                .born()
                .gender()
                .build();
        member.addAuthority(Authority.ofUser(member));
    }
}
