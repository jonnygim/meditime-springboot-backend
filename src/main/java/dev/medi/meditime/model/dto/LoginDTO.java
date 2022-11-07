package dev.medi.meditime.model.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LoginDTO {
    private String email;
    private String password;
}
