package dev.medi.meditime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dev.medi.meditime.model.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

    //public String validateEmail(String email);
    // @Query("SELECT user_email FROM User u WHERE u.userEmail = :userEmail")
    User findByUserEmail(String userEmail);

    User findByUserId(String userId);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.userPw = :userPw WHERE u.userId = :userId")
    void findByUpdate(@Param("userId") String userId, @Param("userPw") String userPw);
}
