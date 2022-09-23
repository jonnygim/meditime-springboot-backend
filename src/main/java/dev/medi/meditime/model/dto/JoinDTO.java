package dev.medi.meditime.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class JoinDTO {
    private String email;
    private String password;
    private String nickname;

    public JoinDTO() {
    }

    public JoinDTO(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
