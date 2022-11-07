package dev.medi.meditime.service;

import java.util.List;

import dev.medi.meditime.model.dto.MedicineDTO;

public interface MedicineService {
    MedicineDTO getMedicine(String itemName, String efcItem);
}
