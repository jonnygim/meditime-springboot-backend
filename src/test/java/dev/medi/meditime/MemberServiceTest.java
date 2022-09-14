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

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RequiredArgsConstructor
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @AfterEach
    public void clean() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 가입이 정상 동작한다.")
    public void signupTest() {

        // given
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId(1L)
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
    @DisplayName("멤버 조회가 정상 동작한다")
    public void getMemberTest() {
        // given
        memberRepository.save(new Member(1L, "jonny@gmail.com", "12345", "jonny", "1997", "M", LocalDate.now()));

        // when
        MemberDTO memberDTO = memberService.getMember(1L);

        // then
        assertThat(memberDTO).extracting("email");
    }

    @Test
    @DisplayName("멤버 이름 수정이 정상 동작한다")
    public void updateMemberNameTest() {
        // given
        Member savedMember = memberRepository.save(new Member(1L, "jonny@gmail.com", "12345", "jonny", "1997", "M", LocalDate.now()));

        // when
        memberService.updateMemberName(new MemberDTO(savedMember.getMemberId(), "gggg"));

        // then
        Member result = memberRepository.findAll().get(0);
        assertThat(result.getName()).isEqualTo("gggg");
    }

    @Test
    @DisplayName("멤버 삭제가 정상 동작한다")
    public void deleteMemberTest() {
        // given
        memberRepository.save(new Member(1L, "jonny@gmail.com", "12345", "jonny", "1997", "M", LocalDate.now()));

        // when
        memberService.deleteMember(1L);

        // then
        assertThat(memberRepository.findAll()).isEmpty();
    }


}
