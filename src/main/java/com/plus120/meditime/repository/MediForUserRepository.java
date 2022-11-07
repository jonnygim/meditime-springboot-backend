package com.plus120.meditime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MediForUserRepository extends JpaRepository<MediForUser, String>{
    
    @Query(value = "select mb.medi_name, m.item_image from medicinebox as mb, medicine as m where m.item_name=mb.medi_name and mb.medi_id=:userId", nativeQuery = true)
    List<MediForUser> findByMediBox(@Param("userId") String userId);
    
}
