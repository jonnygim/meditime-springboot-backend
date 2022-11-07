package dev.medi.meditime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.medi.meditime.dto.MedicineDTO;
import dev.medi.meditime.service.MedicineService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public MedicineDTO getMedicine(@RequestParam("keyword") String itemName, @RequestParam("keyword") String efcItem) {
        return medicineService.getMedicine(itemName, efcItem);
       
    }
}
