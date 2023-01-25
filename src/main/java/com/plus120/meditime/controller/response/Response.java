package com.plus120.meditime.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> { // response 규격화

    private String resultCode;
    private T result;


    // 성공했을 때
    public static <T> Response<T> success(T result) {
        return new Response<>("SUCCESS", result);
    }

    // error
    public static Response<Void> error(String errorCode) {
        return new Response<>(errorCode, null);
    }

}
