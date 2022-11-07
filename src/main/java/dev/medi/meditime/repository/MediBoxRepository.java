package dev.medi.meditime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.medi.meditime.domain.MediBox;

public interface MediBoxRepository extends JpaRepository<MediBox, Long> {
    
//    @Query("select mb.itemName, m.itemImage from MediBox mb, Medi m where mb.itemName=m.itemName and mb.userId=:userId")
//    List<MediBox> selectMediBox(@Param("userId") String userId);
    
}
