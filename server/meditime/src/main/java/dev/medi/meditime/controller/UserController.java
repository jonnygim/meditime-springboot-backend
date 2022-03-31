package dev.medi.meditime.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.medi.meditime.model.dto.UserDTO;
import dev.medi.meditime.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    

    // 회원가입
    @PostMapping("/signup")
    public void insertUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userService.insertUser(userDTO);
    }

    // 회원 정보 조회
    @PostMapping("/userinfo")
    public UserDTO selectUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        
        return userService.selectUser(userDTO);
    }

    // 로그인
    @PostMapping("/login")
    public Boolean userLogin(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);

        return userService.loginUser(userDTO);
    }

    // 회원정보 수정
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    // 회원탈퇴
    @PostMapping("/delete")
    public void deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO);
    }

    // 아이디 중복 검사
    @PostMapping("/validate")
    public Boolean validateUserId(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return userService.validateUserId(userDTO);
    }


    // @PostMapping("/validate")
    // public String validateEmail(@RequestBody String email) {
    //     System.out.println("요청 이메일" + email);
    //     return userService.validateEmail(email);
    // }

    

}
