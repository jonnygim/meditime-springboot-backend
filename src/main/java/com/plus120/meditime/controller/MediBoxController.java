package com.plus120.meditime.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plus120.meditime.service.MediBoxService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medibox")
public class MediBoxController {
    
    private final MediBoxService mediBoxService;

    public MediBoxController(MediBoxService mediBoxService) {
        this.mediBoxService = mediBoxService;
    }




    // @DeleteMapping()
    // public void deleteMediBox(@RequestParam("userId") String userId) {
    //     mediBoxService.deleteMediBox(userId);
    // }

}
