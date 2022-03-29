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
@RequestMapping("/signup")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public void insertUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO);
    }

}
