package dev.medi.meditime.service;

import java.util.List;

import dev.medi.meditime.model.dto.MediDTO;

public interface MediService {
    List<MediDTO> searchMediList(String itemName, String efcItem);
}
