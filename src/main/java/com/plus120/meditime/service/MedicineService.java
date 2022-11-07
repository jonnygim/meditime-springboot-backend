package com.plus120.meditime.service;

import com.plus120.meditime.dto.MedicineDTO;

public interface MedicineService {
    MedicineDTO getMedicine(String itemName, String efcItem);
}
