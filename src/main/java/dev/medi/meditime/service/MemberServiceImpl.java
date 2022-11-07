package dev.medi.meditime.service;

import java.util.NoSuchElementException;

import dev.medi.meditime.config.cache.CacheKey;
import dev.medi.meditime.config.jwt.JwtExpirationEnums;
import dev.medi.meditime.util.JwtTokenUtil;
import dev.medi.meditime.model.LogoutAccessToken;
import dev.medi.meditime.model.RefreshToken;
import dev.medi.meditime.model.dto.*;
import dev.medi.meditime.repository.LogoutAccessTokenRedisRepository;
import dev.medi.meditime.repository.RefreshTokenRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.entity.Member;
import dev.medi.meditime.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import static dev.medi.meditime.config.jwt.JwtExpirationEnums.REFRESH_TOKEN_EXPIRATION_TIME;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RefreshTokenRedisRepository refreshTokenRedisRepository;

    @Autowired
    private LogoutAccessTokenRedisRepository logoutAccessTokenRedisRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void join(JoinDTO joinDTO) {
        System.out.println(joinDTO.getPassword());
        System.out.println(passwordEncoder.encode(joinDTO.getPassword()));
       joinDTO.setPassword(passwordEncoder.encode(joinDTO.getPassword()));
       memberRepository.save(Member.ofUser(joinDTO));
    }

    @Override
    public void joinAdmin(JoinDTO joinDTO) {
        joinDTO.setPassword(passwordEncoder.encode(joinDTO.getPassword()));
        memberRepository.save(Member.ofAdmin(joinDTO));
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        Member member = memberRepository.findByEmail(loginDTO.getEmail()).orElseThrow(() -> new NoSuchElementException("회원이 없습니다."));
        checkPassword(loginDTO.getPassword(), member.getPassword());

        String username = member.getUsername();
        String accessToken = jwtTokenUtil.generateAccessToken(username);
        RefreshToken refreshToken = saveRefreshToken(username);
        return TokenDTO.of(accessToken, refreshToken.getRefreshToken());
    }

    private void checkPassword(String rawPassword, String findMemberPassword) {
        if(!passwordEncoder.matches(rawPassword, findMemberPassword)) {
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }
    }

    private RefreshToken saveRefreshToken(String username) {
        return refreshTokenRedisRepository.save(RefreshToken.createRefreshToken(username,
                jwtTokenUtil.generateRefreshToken(username), REFRESH_TOKEN_EXPIRATION_TIME.getValue()));
    }

    @Override
    public MemberInfo getMemberInfo(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("회원이 없습니다."));
        if(!member.getUsername().equals(getCurrentUsername())) {
            throw new IllegalArgumentException("회원 정보가 일치하지 않습니다.");
        }
        return MemberInfo.builder()
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }

    @Override
    @CacheEvict(value = CacheKey.USER, key = "#username")
    public void logout(TokenDTO tokenDTO, String username) {
        String accessToken = resolveToken(tokenDTO.getAccessToken());
        long remainMilliSeconds = jwtTokenUtil.getRemainMilliSeconds(accessToken);
        refreshTokenRedisRepository.deleteById(username);
        logoutAccessTokenRedisRepository.save(LogoutAccessToken.of(accessToken, username, remainMilliSeconds));
    }

    private String resolveToken(String token) {
        return token.substring(7);
    }

    @Override
    public TokenDTO reissue(String refreshToken) {
        refreshToken = resolveToken(refreshToken);
        String username = getCurrentUsername();
        RefreshToken redisRefreshToken = refreshTokenRedisRepository.findById(username).orElseThrow(NoSuchElementException::new);

        if(refreshToken.equals(redisRefreshToken.getRefreshToken())) {
            return reissueRefreshToken(refreshToken, username);
        }
        throw new IllegalArgumentException("토큰이 일치하지 않습니다.");
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }

    private TokenDTO reissueRefreshToken(String refreshToken, String username) {
        if(lessThanReissueExpirationTimesLeft(refreshToken)) {
            String accessToken = jwtTokenUtil.generateAccessToken(username);
            return TokenDTO.of(accessToken, saveRefreshToken(username).getRefreshToken());
        }
        return TokenDTO.of(jwtTokenUtil.generateAccessToken(username), refreshToken);
    }

    private boolean lessThanReissueExpirationTimesLeft(String refreshToken) {
        return jwtTokenUtil.getRemainMilliSeconds(refreshToken) < JwtExpirationEnums.REISSUE_EXPIRATION_TIME.getValue();
    }

    // 회원 정보 조회
//    @Override
//    public MemberDTO getMember(Long memberId) {
//
//        Member member = memberRepository.findByMemberId(memberId).orElseThrow(IllegalArgumentException::new);
//
//        MemberDTO result =  MemberDTO.builder()
//                .memberId(member.getMemberId())
//                .email(member.getEmail())
//                .name(member.getName())
//                .born(member.getBorn())
//                .gender(member.getGender())
//                .build();
//
//        return result;
//
//    }

    // 닉네임 변경
//    @Override
//    public void updateMemberName(MemberDTO memberDTO) {
//
//       Member member = memberRepository.findByMemberId(memberDTO.getMemberId()).orElseThrow(IllegalArgumentException::new);
//
//       member.updateName(memberDTO.getName());
//
//       memberRepository.save(member);
//    }

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
//    @Override
//    public void deleteMember(Long memberId) {
//        Member user = memberRepository.findByMemberId(memberId).orElseThrow(IllegalArgumentException::new);
//        memberRepository.delete(user);
//    }
}

