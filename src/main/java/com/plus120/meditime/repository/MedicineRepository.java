package com.plus120.meditime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.plus120.meditime.domain.Medicine;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicineRepository extends JpaRepository<Medicine, String>{

//    @Query("select m from Medicine m where m.itemName like %:itemName% or m.efcItem like %:efcItem%")
//    List<Medicine> searchMediList(@Param("itemName") String itemName, @Param("efcItem") String efcItem );
//
}

