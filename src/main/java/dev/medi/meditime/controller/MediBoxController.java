package dev.medi.meditime.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.medi.meditime.model.dto.MediBoxDTO;
import dev.medi.meditime.model.dto.MediForUserDTO;
import dev.medi.meditime.service.MediBoxService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medibox")
public class MediBoxController {
    
    private final MediBoxService mediBoxService;

    public MediBoxController(MediBoxService mediBoxService) {
        this.mediBoxService = mediBoxService;
    }

    @PostMapping()
    public void insertMediBox(@RequestBody MediBoxDTO mediBoxDTO) {
        System.out.println("이름" + mediBoxDTO.getItemName());
        System.out.println("유저아이디" + mediBoxDTO.getUserId());
        System.out.println("아이디" + mediBoxDTO.getId());
        mediBoxService.insertMediBox(mediBoxDTO);
    }

    @GetMapping("/select")
    public List<MediForUserDTO> selectMediBox(@RequestParam("userId") String UserId) {
        System.out.println("컨트롤러" + UserId);
        return mediBoxService.selectMediBox(UserId);
    }

    // @DeleteMapping()
    // public void deleteMediBox(@RequestParam("userId") String userId) {
    //     mediBoxService.deleteMediBox(userId);
    // }

}
