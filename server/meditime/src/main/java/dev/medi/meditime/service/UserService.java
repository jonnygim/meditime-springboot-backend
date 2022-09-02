package dev.medi.meditime.service;

import dev.medi.meditime.model.dto.UserDTO;

public interface UserService {
    
    // 로그인
    Boolean loginUser(UserDTO userDTO);

    // 회원 가입
    void insertUser(UserDTO userDTO);

    // 회원 정보 수정
    void updateUserId(UserDTO userDTO);

    void updateUserPassword(UserDTO userDTO);

    // 회원 탈퇴
    void deleteUser(UserDTO userDTO);

    // 회원 정보 조회
    UserDTO selectUser(String userId);

    // 회원 아이디 중복 확인
    Boolean validateUserId(String userId);

}
