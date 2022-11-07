package dev.medi.meditime.domain;

import javax.persistence.*;

import dev.medi.meditime.dto.JoinDTO;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Builder
@Table(name="MEMBERS")
@DynamicUpdate
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long memberId;

    @Column(unique = true)
    private String username;

    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String nickName;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Authority> authorities = new HashSet<>();

    public Member() {}

    public Member(Long memberId, String username, String email, String password, String nickName, Set<Authority> authorities) {
        this.memberId = memberId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.authorities = authorities;
    }

    public static Member ofUser(JoinDTO joinDTO) {
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email(joinDTO.getEmail())
                .password(joinDTO.getPassword())
                .nickName(joinDTO.getNickname())
                .build();
        member.addAuthority(Authority.ofUser(member));
        return member;
    }

    public static Member ofAdmin(JoinDTO joinDTO) {
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email(joinDTO.getEmail())
                .password(joinDTO.getPassword())
                .nickName(joinDTO.getNickname())
                .build();
        member.addAuthority(Authority.ofAdmin(member));
        return member;
    }

    private void addAuthority(Authority authority) {
        authorities.add(authority);
    }

    public List<String> getRoles() {
        return authorities.stream()
                .map(Authority::getRole)
                .collect(toList());
    }
}
