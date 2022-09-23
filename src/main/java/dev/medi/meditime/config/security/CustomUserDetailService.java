package dev.medi.meditime.config.security;

import dev.medi.meditime.config.cache.CacheKey;
import dev.medi.meditime.model.entity.Member;
import dev.medi.meditime.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    @Cacheable(value = CacheKey.USER, key = "#username", unless = "#result == null")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsernameWithAuthority(username).orElseThrow(() -> new NoSuchElementException("없는 회원입니다."));
        return CustomUserDetails.of(member);
    }
}
