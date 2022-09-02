package dev.medi.meditime.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.service.MemberService;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    // 회원 정보 조회
    @GetMapping(path = "/{userId}")
    public MemberDTO getMember(@PathVariable Integer memberId) {
        return memberService.getMember(memberId);
    }

    // 로그인
    @PostMapping
    public Boolean userLogin(@RequestBody MemberDTO memberDTO) {
        return memberService.loginUser(memberDTO);
    }

    // 회원가입
    @PostMapping("/signup")
    public void insertUser(@RequestBody MemberDTO memberDTO) {
        memberService.insertUser(memberDTO);
    }

    // 아이디 중복 검사
    @GetMapping("/validate/{userId}")
    public Boolean validateUserId(@PathVariable String userId) {
        return memberService.validateUserId(userId);
    }



    // 닉네임 변경
    @PatchMapping("/userId")
    public void updateUserId(@RequestBody MemberDTO memberDTO) throws Exception {
        System.out.println(memberDTO.getUserId());
        memberService.updateUserId(memberDTO);
    }

    // 비밀번호 변경
    @PatchMapping("/password")
    public void updateUserPassword(@RequestBody MemberDTO memberDTO) throws Exception {
        memberService.updateUserPassword(memberDTO);
    }

    // 회원탈퇴
    @DeleteMapping
    public void deleteUser(@RequestBody MemberDTO memberDTO) {
        memberService.deleteUser(memberDTO);
    }



}
