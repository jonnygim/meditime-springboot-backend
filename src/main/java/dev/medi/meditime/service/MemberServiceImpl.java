package dev.medi.meditime.service;

import java.time.LocalDate;
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

    // 회원가입
    @Override
    public void signup(MemberDTO memberDTO) {

        Member newMember = new Member(memberDTO.getMemberId(), memberDTO.getEmail(), memberDTO.getPassword(), memberDTO.getName(), memberDTO.getBorn(), memberDTO.getGender(), LocalDate.now());
        memberRepository.save(newMember);

    }

    // 회원 정보 조회
    @Override
    public MemberDTO getMember(Long memberId) {

        Member member = memberRepository.findByMemberId(memberId).orElseThrow(IllegalArgumentException::new);

        MemberDTO result =  MemberDTO.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .name(member.getName())
                .born(member.getBorn())
                .gender(member.getGender())
                .build();

        return result;

    }

    // 닉네임 변경
    @Override
    public void updateMemberName(MemberDTO memberDTO) {

       Member member = memberRepository.findByMemberId(memberDTO.getMemberId()).orElseThrow(IllegalArgumentException::new);

       member.updateName(memberDTO.getName());
    }

    // 비밀번호 변경
//    @Override
//    public void updateUserPassword(MemberDTO memberDTO){
//
//        Member userSave = memberRepository.findByUserEmail(memberDTO.getEmail());
//
//        //userSave.setUserPw(memberDTO.getUserPw());
//
//        memberRepository.save(userSave);
//    }



//    @Override
//    public Boolean validateUserId(String userId) {
//        System.out.println("받아온 아이디" + userId);
//
//        try {
//            Member dbUserId = memberRepository.findByMemberId(userId);
//
//            if (dbUserId.getUserId().equals(userId) && !userId.isEmpty()) {
//                System.out.println("DB아이디 : " + dbUserId.getUserId());
//
//                return true;
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//            System.out.println("error: " + e); // 다른 항목들 null 값이라서
//        }
//
//        return false;
//    }




    // 회원 탈퇴
    @Override
    public void deleteMember(Long memberId) {
        Member user = memberRepository.findByMemberId(memberId).orElseThrow(IllegalArgumentException::new);
        memberRepository.delete(user);
    }
}

