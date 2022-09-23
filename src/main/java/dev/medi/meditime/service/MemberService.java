package dev.medi.meditime.service;

import dev.medi.meditime.model.dto.*;

public interface MemberService {

    void join(JoinDTO joinDTO);
    void joinAdmin(JoinDTO joinDTO);

    TokenDTO login(LoginDTO loginDTO);
    void logout(TokenDTO tokenDTO, String username);

    MemberInfo getMemberInfo(String email);
    
    TokenDTO reissue(String refreshToken);

}
