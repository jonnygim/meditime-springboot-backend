package dev.medi.meditime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.medi.meditime.model.dto.MediBoxDTO;
import dev.medi.meditime.model.dto.MediDTO;
import dev.medi.meditime.model.entity.Medi;
import dev.medi.meditime.model.entity.MediBox;
import dev.medi.meditime.repository.MediBoxRepository;

public class MediBoxServiceImpl implements MediBoxService{

    @Autowired
    private MediBoxRepository mediBoxRepository;
    
    // medicinbox 담기
    @Override
    public void insertMediBox(MediBoxDTO mediBoxDTO) {

        MediBox medibox = new MediBox();

        medibox.setUserId(mediBoxDTO.getUserId());
        medibox.setItemName(mediBoxDTO.getItemName());

        mediBoxRepository.save(medibox);

    }

    @Override
    // public List<MediDTO> selectMediBox(String userId) {
        List<Medi> list = mediBoxRepository.selectMediBox(userId);
    }

    // ? 식별자 줄수 없어서 불가일듯 안되면 쿼리문 날리자
    // medicin 담기 취소
    @Override
    public void deleteMediBox(String userId) {
        mediBoxRepository.deleteById(userId);
    }


    


}
