package dev.medi.meditime.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.model.dto.MediDTO;
import dev.medi.meditime.model.entity.Medi;
import dev.medi.meditime.repository.MediRepository;

@Service
public class MediServiceImpl implements MediService{
    
    @Autowired
    private MediRepository mediRepository;

    @Override
    public List<MediDTO> searchMediList(String itemName, String efcItem) {
        System.out.println("keyword" + itemName + efcItem);

        // List<Medi> list = mediRepository.findByitemNameContainingOrEfcItemContaining(itemName, efcItem);
        List<Medi> list = mediRepository.searchMediList(itemName, efcItem);

        List<MediDTO> result = list.stream().map(r -> new MediDTO(r)).collect(Collectors.toList());
        System.out.println(result);
        return result;
    
    }

}
