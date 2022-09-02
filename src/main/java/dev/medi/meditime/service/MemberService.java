package dev.medi.meditime.service;

import dev.medi.meditime.model.dto.MemberDTO;

public interface MemberService {
    
    // 로그인
    Boolean loginUser(MemberDTO memberDTO);

    // 회원 가입
    void insertUser(MemberDTO memberDTO);

    // 회원 정보 수정
    void updateUserId(MemberDTO memberDTO);

    void updateUserPassword(MemberDTO memberDTO);

    // 회원 탈퇴
    void deleteUser(MemberDTO memberDTO);

    // 회원 정보 조회
    MemberDTO selectUser(String userId);

    // 회원 아이디 중복 확인
    Boolean validateUserId(String userId);

}
