package dev.medi.meditime.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.model.entity.User;
import dev.medi.meditime.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    // 회원가입
    @Override
    public void insertUser(MemberDTO memberDTO) {

        User user = new User();
        
        user.setUserId(memberDTO.getUserId());
        user.setUserPw(memberDTO.getUserPw());
        user.setUserEmail(memberDTO.getUserEmail());
        user.setUserBorn(memberDTO.getUserBorn());
        user.setUserGender(memberDTO.getUserGender());
        user.setRegDate(memberDTO.getRegDate());

        memberRepository.save(user);

    }

    // 닉네임 변경
    @Override
    public void updateUserId(MemberDTO memberDTO) {
        System.out.println(memberDTO.getUserId());

        User user = new User();
        if(memberRepository.findByUserEmail(memberDTO.getUserEmail()) != null) {
            user = User.builder()
                    .userEmail(memberDTO.getUserEmail())
                    .userId(memberDTO.getUserId())
                    .regDate(memberDTO.getRegDate())
                    .build();
        }

        memberRepository.save(user);
    }

    // 비밀번호 변경
    @Override
    public void updateUserPassword(MemberDTO memberDTO){

        User userSave = memberRepository.findByUserEmail(memberDTO.getUserEmail());

        userSave.setUserPw(memberDTO.getUserPw());

        memberRepository.save(userSave);
    }

    // 회원 정보 조회
    @Override
    public MemberDTO selectUser(String userId) {
        System.out.println("받아온 User 아이디 : " + userId);

        // DB  
        User user = memberRepository.findByUserId(userId);

        MemberDTO sMemberDTO = new MemberDTO();

        sMemberDTO.setUserId(user.getUserId());
        sMemberDTO.setUserPw(user.getUserPw());
        sMemberDTO.setUserEmail(user.getUserEmail());
        sMemberDTO.setUserBorn(user.getUserBorn());
        sMemberDTO.setUserGender(user.getUserGender());
        sMemberDTO.setRegDate(user.getRegDate());
        
        return sMemberDTO;

    }

    @Override
    public Boolean validateUserId(String userId) {
        System.out.println("받아온 아이디" + userId);
    
        try {
            User dbUserId = memberRepository.findByUserId(userId);

            if (dbUserId.getUserId().equals(userId) && !userId.isEmpty()) {
                System.out.println("DB아이디 : " + dbUserId.getUserId());

                return true;
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error: " + e); // 다른 항목들 null 값이라서 
        }

        return false;
    }


    // 로그인
    @Override
    public Boolean loginUser(MemberDTO memberDTO) {
        // 받아온 id/ pw 확인
        System.out.println(memberDTO.getUserId());
        System.out.println(memberDTO.getUserPw());
        // System.out.println(userDTO.getUserEmail()); 넘어 온 값이 없으니 null
        
        // repo 값 가져오기
        try {
            User user = memberRepository.findByUserId(memberDTO.getUserId());
            System.out.println(memberDTO.getUserId() + "유저 비밀번호" + user.getUserPw());

            if(memberDTO.getUserPw().equals(user.getUserPw())) {
                return true;
            } 
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error : " + e);
        }
        
        return false;
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(MemberDTO memberDTO) {
        Optional<User> user = memberRepository.findById(memberDTO.getUserId());

        user.ifPresent(selectUser ->{
            memberRepository.delete(selectUser);
        });
    }
}

