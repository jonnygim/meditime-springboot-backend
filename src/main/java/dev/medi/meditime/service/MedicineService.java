package dev.medi.meditime.service;

import dev.medi.meditime.dto.MedicineDTO;

public interface MedicineService {
    MedicineDTO getMedicine(String itemName, String efcItem);
}
