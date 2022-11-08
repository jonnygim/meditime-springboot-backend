package com.plus120.meditime.repository;

import com.plus120.meditime.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

//    Optional<UserAccount> findByEmail(String email);
//
//    Optional<UserAccount> findByUsername(String username);
//
//    @Query("select m from Member m join fetch m.authorities a where m.username = :username")
//    Optional<UserAccount> findByUsernameWithAuthority(String username);
}
