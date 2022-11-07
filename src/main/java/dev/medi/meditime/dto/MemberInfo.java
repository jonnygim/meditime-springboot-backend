package dev.medi.meditime.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MemberInfo {
    private String email;
    private String username;
}
