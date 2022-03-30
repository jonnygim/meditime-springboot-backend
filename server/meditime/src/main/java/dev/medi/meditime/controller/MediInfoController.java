package dev.medi.meditime.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.medi.meditime.model.dto.MediDTO;
import dev.medi.meditime.service.MediService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medicines")
public class MediInfoController {
    
    private final MediService mediService;

    public MediInfoController(MediService mediService) {
        this.mediService = mediService;
    }

    @GetMapping()
    public List<MediDTO> searchMediList(@RequestParam("keyword") String itemName, @RequestParam("keyword") String efcItem) {
        //System.out.println("keyword" + itemName + efcItem);
        return mediService.searchMediList(itemName, efcItem);
       
    }
}
