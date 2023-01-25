package com.plus120.meditime.service;

import com.plus120.meditime.model.User;
import com.plus120.meditime.model.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Transactional
    public User join(String userId, String password, String email, String nickname) {
        // 회원가입하려는 userName으로 회원가입된 user가 있는지

        // 회원가입 진행 = user를 등록

        return new User(userId, password, email, nickname);
    }
}
