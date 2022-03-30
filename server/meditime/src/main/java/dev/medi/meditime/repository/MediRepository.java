package dev.medi.meditime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.medi.meditime.model.entity.Medi;

public interface MediRepository extends JpaRepository<Medi, String>{
    List<Medi> findByitemNameContainingOrEfcItemContaining(String itemName, String efcItem);
}
