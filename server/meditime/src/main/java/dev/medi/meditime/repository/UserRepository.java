package dev.medi.meditime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.medi.meditime.model.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
