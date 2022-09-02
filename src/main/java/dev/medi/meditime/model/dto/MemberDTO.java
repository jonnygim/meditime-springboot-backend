package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Builder
public class MemberDTO {
    private Long memberId;
    private String email;
    private String password;
    private String born;
    private String gender;
    private Date regDate;

    public MemberDTO() {}

    public MemberDTO(Member m) {
        this.memberId = m.getMemberId();
        this.email = m.getEmail();
        this.password = m.getPassword();
        this.born = m.getBorn();
        this.gender = m.getGender();
        this.regDate = m.getRegDate();
    }

    @Builder
    public MemberDTO(Long memberId, String email, String password, String born, String gender, Date regDate) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.born = born;
        this.gender = gender;
        this.regDate = regDate;
    }
}
