package dev.medi.meditime.service;

import java.util.List;

import dev.medi.meditime.model.dto.MediBoxDTO;
import dev.medi.meditime.model.dto.MediForUserDTO;

public interface MediBoxService {
    void insertMediBox(MediBoxDTO mediBoxDTO);

    // void deleteMediBox(String userId);

    List<MediForUserDTO> selectMediBox(String userId);
}
