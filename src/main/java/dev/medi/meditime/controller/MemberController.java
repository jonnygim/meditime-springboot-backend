package dev.medi.meditime.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.service.MemberService;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    // 회원 정보 조회
    @GetMapping(path = "/{memberId}")
    public MemberDTO getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    // 로그인
    @PostMapping
    public Boolean memberLogin(@RequestBody MemberDTO memberDTO) {
        return memberService.memberLogin(memberDTO);
    }

    // 회원가입
    @PostMapping("/signup")
    public void signup(@RequestBody MemberDTO memberDTO) {
        memberService.signup(memberDTO);
    }

    // 아이디 중복 검사
//    @GetMapping("/validate/{userId}")
//    public Boolean validateMemberId(@PathVariable String userId) {
//        return memberService.validateUserId(userId);
//    }



    // 닉네임 변경
//    @PatchMapping("/userId")
//    public void updateMemberId(@RequestBody MemberDTO memberDTO) throws Exception {
//        System.out.println(memberDTO.getMemberId());
//        memberService.updateUserId(memberDTO);
//    }

    // 비밀번호 변경
//

    // 회원탈퇴
    @DeleteMapping("/{id}")
    public void deleteMember(@RequestBody MemberDTO memberDTO) {
        memberService.deleteUser(memberDTO);
    }



}
