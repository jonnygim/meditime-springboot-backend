package dev.medi.meditime.repository;

import dev.medi.meditime.domain.MedicineBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediBoxRepository extends JpaRepository<MedicineBox, Long> {
    
//    @Query("select mb.itemName, m.itemImage from MediBox mb, Medi m where mb.itemName=m.itemName and mb.userId=:userId")
//    List<MediBox> selectMediBox(@Param("userId") String userId);
    
}
