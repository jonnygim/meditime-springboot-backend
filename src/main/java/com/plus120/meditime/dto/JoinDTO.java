package com.plus120.meditime.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JoinDTO {
    private String email;
    private String password;
    private String nickname;
}
