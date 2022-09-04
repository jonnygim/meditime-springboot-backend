package dev.medi.meditime.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.model.entity.Member;
import dev.medi.meditime.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    // 회원 정보 조회
    @Override
    public MemberDTO getMember(Long memberId) {

        Member member = memberRepository.findByMemberId(memberId);

        MemberDTO result =  MemberDTO.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .born(member.getBorn())
                .gender(member.getGender())
                .build();

        return result;

    }

    // 로그인
    @Override
    public Boolean memberLogin(MemberDTO memberDTO) {

        // repo 값 가져오기
        try {
            Member user = memberRepository.findByMemberId(memberDTO.getMemberId());

            if(memberDTO.getPassword().equals(user.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("error : " + e);
        }

        return false;
    }

    // 회원가입
    @Override
    public void insertUser(MemberDTO memberDTO) {

        Member user = new Member();
        
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

        Member user = new Member();
        if(memberRepository.findByUserEmail(memberDTO.getUserEmail()) != null) {
            user = Member.builder()
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

        Member userSave = memberRepository.findByUserEmail(memberDTO.getUserEmail());

        userSave.setUserPw(memberDTO.getUserPw());

        memberRepository.save(userSave);
    }



    @Override
    public Boolean validateUserId(String userId) {
        System.out.println("받아온 아이디" + userId);
    
        try {
            Member dbUserId = memberRepository.findByUserId(userId);

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




    // 회원 탈퇴
    @Override
    public void deleteUser(MemberDTO memberDTO) {
        Optional<Member> user = memberRepository.findById(memberDTO.getUserId());

        user.ifPresent(selectUser ->{
            memberRepository.delete(selectUser);
        });
    }
}

