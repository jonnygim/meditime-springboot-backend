package dev.medi.meditime.service;

import dev.medi.meditime.model.dto.MemberDTO;

public interface MemberService {

    // 회원 가입
    void signup(MemberDTO memberDTO);

    // 회원 정보 조회
    MemberDTO getMember(Long memberId);
    
    // 회원 정보 수정
    void updateMemberName(MemberDTO memberDTO);

//    void updateUserId(MemberDTO memberDTO);
//
//    void updateUserPassword(MemberDTO memberDTO);

    // 회원 탈퇴
    void deleteMember(Long memberId);



    // 회원 아이디 중복 확인
//    Boolean validateUserId(String userId);

}
