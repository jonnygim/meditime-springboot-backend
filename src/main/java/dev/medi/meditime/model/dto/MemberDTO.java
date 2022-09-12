package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
public class MemberDTO {
    private Long memberId;
    private String email;
    private String password;
    private String name;
    private String born;
    private String gender;
    private LocalDate regDate;

    public MemberDTO() {}

    public MemberDTO(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public MemberDTO(Member m) {
        this.memberId = m.getMemberId();
        this.email = m.getEmail();
        this.password = m.getPassword();
        this.name = m.getName();
        this.born = m.getBorn();
        this.gender = m.getGender();
        this.regDate = m.getRegDate();
    }

    @Builder
    public MemberDTO(Long memberId, String email, String password, String name, String born, String gender, LocalDate regDate) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.regDate = regDate;
    }
}
