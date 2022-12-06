package com.nest.patientappbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @PostMapping("/add")
    public String addPatient(){
        return "Added successfully";
    }

    @GetMapping("/view")
    public String viewPatient(){
        return "Patient view successful";
    }

}
