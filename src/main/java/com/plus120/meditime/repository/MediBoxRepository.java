package com.plus120.meditime.repository;

import com.plus120.meditime.model.MedicineBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediBoxRepository extends JpaRepository<MedicineBox, Long> {
    
//    @Query("select mb.itemName, m.itemImage from MediBox mb, Medi m where mb.itemName=m.itemName and mb.userId=:userId")
//    List<MediBox> selectMediBox(@Param("userId") String userId);
    
}
