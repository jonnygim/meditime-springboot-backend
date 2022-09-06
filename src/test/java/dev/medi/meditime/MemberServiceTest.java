package dev.medi.meditime;

import dev.medi.meditime.model.dto.MemberDTO;
import dev.medi.meditime.model.entity.Member;
import dev.medi.meditime.repository.MemberRepository;
import dev.medi.meditime.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RequiredArgsConstructor
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private EntityManager entityManager;

    @AfterEach
    void clean() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 가입이 정상 동작한다.")
    void signupTest() {

        // given
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(null)
                .email("jonny@gmail.com")
                .password("1234")
                .name("jonny")
                .born("1995")
                .gender("M")
                .regDate(LocalDate.now())
                .build();

        // when
        memberService.signup(memberDTO);

        // then
        List<Member> member = memberRepository.findAll();
        assertThat(member.get(0).getEmail()).isEqualTo("jonny@gmail.com");
        assertThat(member.get(0).getPassword()).isEqualTo("1234");
        assertThat(member.get(0).getName()).isEqualTo("jonny");
        assertThat(member.get(0).getBorn()).isEqualTo("1995");
        assertThat(member.get(0).getGender()).isEqualTo("M");
    }

    @Test
    void getMemberTest() {
        // given
        memberRepository.save(new Member(null, "jonny@gmail.com", "12345", "jonny", "1997", "M", LocalDate.now()));

        // when
        MemberDTO memberDTO = memberService.getMember("jonny");

        // then
        assertThat(memberDTO).extracting("email");
    }


}
