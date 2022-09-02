package dev.medi.meditime.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.MediBoxDTO;
import dev.medi.meditime.model.dto.MediForUserDTO;
import dev.medi.meditime.model.entity.MediBox;
import dev.medi.meditime.model.entity.MediForUser;
import dev.medi.meditime.repository.MediBoxRepository;
import dev.medi.meditime.repository.MediForUserRepository;

@Service
public class MediBoxServiceImpl implements MediBoxService{

    @Autowired
    private MediBoxRepository mediBoxRepository;

    @Autowired
    private MediForUserRepository mediForUserRepository;

    // medicinbox 담기
    @Override
    public void insertMediBox(MediBoxDTO mediBoxDTO) {

        MediBox medibox = new MediBox();

        medibox.setId(mediBoxDTO.getId());
        medibox.setUserId(mediBoxDTO.getUserId());
        medibox.setItemName(mediBoxDTO.getItemName());
        
        mediBoxRepository.save(medibox);

    }

    @Override
    public List<MediForUserDTO> selectMediBox(String userId) {
        List<MediForUser> list = mediForUserRepository.findByMediBox(userId);
        
        System.out.println("리스트" + list);

        List<MediForUserDTO> result = list.stream().map(r -> new MediForUserDTO(r)).collect(Collectors.toList());
        

        return result;
    }

    // ? 식별자 줄수 없어서 불가일듯 안되면 쿼리문 날리자
    // medicin 담기 취소
    // @Override
    // public void deleteMediBox(String userId) {
    //     mediBoxRepository.deleteById(userId);
    // }
    
}
