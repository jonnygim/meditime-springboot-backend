package com.plus120.meditime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("/medicines")
@Controller
public class MedicineController {

    @GetMapping
    public String medicines() {

        return "medicines/index";
    }

    @GetMapping("/{medicineId}")
    public String medicine() {

        return "";
    }

}
