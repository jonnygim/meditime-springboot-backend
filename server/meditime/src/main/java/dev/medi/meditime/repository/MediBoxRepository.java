package dev.medi.meditime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.medi.meditime.model.entity.Medi;
import dev.medi.meditime.model.entity.MediBox;

public interface MediBoxRepository extends JpaRepository<MediBox, String> {
    @Query("selet mb.itemName, m.itemImage from MediBox mb, Medi m where mb.itemName=m.itemName and mb.userId=:userId")
    List<Medi> selectMediBox(@Param("userId") String userId);
}
