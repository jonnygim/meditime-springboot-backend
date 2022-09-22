package dev.medi.meditime.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class JwtHeaderUtilEnums {

    GRANT_TYPE("JWT 타입 / Bearer ", "Bearer ");

    private String description;
    private String value;

}
