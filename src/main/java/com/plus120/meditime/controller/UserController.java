package com.plus120.meditime.controller;


import com.plus120.meditime.controller.request.UserJoinRequest;
import com.plus120.meditime.controller.response.Response;
import com.plus120.meditime.controller.response.UserJoinResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        return null;
    }

}
