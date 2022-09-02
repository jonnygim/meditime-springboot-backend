package dev.medi.meditime.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.medi.meditime.model.dto.UserDTO;
import dev.medi.meditime.service.UserService;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    // 로그인
    @PostMapping
    public Boolean userLogin(@RequestBody UserDTO userDTO) {
        return userService.loginUser(userDTO);
    }

    // 회원가입
    @PostMapping("/signup")
    public void insertUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO);
    }

    // 아이디 중복 검사
    @GetMapping("/validate/{userId}")
    public Boolean validateUserId(@PathVariable String userId) {
        return userService.validateUserId(userId);
    }

    // 회원 정보 조회
    @GetMapping("{userId}")
    public UserDTO selectUser(@PathVariable String userId) {
        return userService.selectUser(userId);
    }

    // 닉네임 변경
    @PatchMapping("/userId")
    public void updateUserId(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getUserId());
        userService.updateUserId(userDTO);
    }

    // 비밀번호 변경
    @PatchMapping("/password")
    public void updateUserPassword(@RequestBody UserDTO userDTO) throws Exception {
        userService.updateUserPassword(userDTO);
    }

    // 회원탈퇴
    @DeleteMapping
    public void deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO);
    }



}
