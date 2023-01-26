package com.plus120.meditime.service;

import com.plus120.meditime.exception.ErrorCode;
import com.plus120.meditime.exception.MeditimeApplicationException;
import com.plus120.meditime.model.User;
import com.plus120.meditime.model.entity.UserEntity;
import com.plus120.meditime.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User join(String userName, String password, String email, String nickname) {
        // 회원가입하려는 userName으로 회원가입된 user가 있는지 - 동일한 userName 확인 시 예외처리
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new MeditimeApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });

        // 회원가입 진행 = user 등록
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, encoder.encode(password), email, nickname));
        return User.fromEntity(userEntity);
    }
}
