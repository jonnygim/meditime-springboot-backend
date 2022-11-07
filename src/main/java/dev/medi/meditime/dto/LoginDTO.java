package dev.medi.meditime.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LoginDTO {
    private String email;
    private String password;
}
