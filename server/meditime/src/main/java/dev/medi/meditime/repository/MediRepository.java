package dev.medi.meditime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.medi.meditime.model.entity.Medi;

public interface MediRepository extends JpaRepository<Medi, String>{

    // List<Medi> findByitemNameContainingOrEfcItemContaining(String itemName, String efcItem);

    @Query("select m from Medi m where m.itemName like %:itemName% or m.efcItem like %:efcItem%")
    List<Medi> searchMediList(@Param("itemName") String itemName, @Param("efcItem") String efcItem );
}

