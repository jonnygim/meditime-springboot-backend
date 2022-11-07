package com.plus120.meditime.service;

import java.util.List;

import com.plus120.meditime.dto.MediBoxDTO;
import com.plus120.meditime.dto.MediForUserDTO;

public interface MediBoxService {
    
    void insertMediBox(MediBoxDTO mediBoxDTO);

    // void deleteMediBox(String userId);

    List<MediForUserDTO> selectMediBox(String userId);

}
