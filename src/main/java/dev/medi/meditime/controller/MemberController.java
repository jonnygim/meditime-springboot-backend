package dev.medi.meditime.controller;


import dev.medi.meditime.config.jwt.JwtTokenUtil;
import dev.medi.meditime.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.medi.meditime.service.MemberService;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinDTO joinDTO) {
        memberService.join(joinDTO);
        return "회원가입 완료";
    }

    @PostMapping("/join/admin")
    public String joinAdmin(@RequestBody JoinDTO joinDTO) {
        memberService.joinAdmin(joinDTO);
        return "관리자 회원 가입 완료";
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(memberService.login(loginDTO));
    }

    @GetMapping("/members/{email}")
    public MemberInfo getMemberInfo(@PathVariable String email) {
        return memberService.getMemberInfo(email);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDTO> reissue(@RequestHeader("RefreshToken") String refreshToken) {
        return ResponseEntity.ok(memberService.reissue(refreshToken));
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String accessToken,
                       @RequestHeader("RefreshToken") String refreshToken) {
        String username = jwtTokenUtil.getUsername(resolveToken(accessToken));
        memberService.logout(TokenDTO.of(accessToken, refreshToken), username);
    }

    private String resolveToken(String accessToken) {
        return accessToken.substring(7);
    }

    // 회원 정보 조회
//    @GetMapping(path = "/{id}")
//    public MemberDTO getMember(@PathVariable Long memberId) {
//        return memberService.getMember(memberId);
//    }

    // 닉네임 변경
//    @PatchMapping("")
//    public void updateMemberName(@RequestBody MemberDTO memberDTO) {
//        memberService.updateMemberName(memberDTO);
//    }

    // 비밀번호 변경

    // 아이디 중복 검사
//    @GetMapping("/validate/{userId}")
//    public Boolean validateMemberId(@PathVariable String userId) {
//        return memberService.validateUserId(userId);
//

    // 회원탈퇴
//    @DeleteMapping("/{id}")
//    public void deleteMember(@PathVariable Long memberId) {
//        memberService.deleteMember(memberId);
//    }



}
