package com.plus120.meditime.repository;

import com.plus120.meditime.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{

    Optional<UserEntity> findByUserName(String userName);

//    @Query("select m from Member m join fetch m.authorities a where m.username = :username")
//    Optional<UserAccount> findByUsernameWithAuthority(String username);
}
