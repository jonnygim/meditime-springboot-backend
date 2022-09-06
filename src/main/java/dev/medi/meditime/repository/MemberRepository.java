package dev.medi.meditime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.medi.meditime.model.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String>{

//    Member findByUserEmail(String userEmail);

    Optional<Member> findByName(String name);
//    @Transactional
//    @Modifying
//    @Query("UPDATE User u SET u.userPw = :userPw WHERE u.userId = :userId")
//    void findByUpdate(@Param("userId") String userId, @Param("userPw") String userPw);
//
}
