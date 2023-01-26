package com.plus120.meditime.controller;


import com.plus120.meditime.controller.request.UserJoinRequest;
import com.plus120.meditime.controller.response.Response;
import com.plus120.meditime.controller.response.UserJoinResponse;
import com.plus120.meditime.model.User;
import com.plus120.meditime.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        User user = userService.join(request.getUserName(), request.getUserPassword(), request.getEmail(), request.getNickname());
        return Response.success(UserJoinResponse.fromUser(user));
    }

}
