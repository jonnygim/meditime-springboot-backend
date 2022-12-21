package com.plus120.meditime.controller;

import com.plus120.meditime.domain.constant.MedicineSearchType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
