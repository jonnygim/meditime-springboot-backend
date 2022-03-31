package dev.medi.meditime.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.medi.meditime.model.dto.MediBoxDTO;
import dev.medi.meditime.model.dto.MediDTO;
import dev.medi.meditime.service.MediBoxService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class MediBoxController {
    
    private final MediBoxService mediBoxService;

    public MediBoxController(MediBoxService mediBoxService) {
        this.mediBoxService = mediBoxService;
    }

    @PostMapping()
    public void insertMediBox(@RequestBody MediBoxDTO mediBoxDTO) {
        mediBoxService.insertMediBox(mediBoxDTO);
    }

    // @GetMapping()
    // public List<MediDTO> selectMediBox(@RequestParam("userId") String UserId) {
    //     return mediBoxService.selectMediBox(UserId);
    // }

    @DeleteMapping()
    public void deleteMediBox(@RequestParam("userId") String userId) {
        mediBoxService.deleteMediBox(userId);
    }


}
