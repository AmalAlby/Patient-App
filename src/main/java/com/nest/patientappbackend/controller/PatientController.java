package com.nest.patientappbackend.controller;

import com.nest.patientappbackend.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String addPatient(@RequestBody Patient p){
        System.out.println(p.getPatientName());
        System.out.println(p.getPatientNumber());
        System.out.println(p.getDoctorName());
        System.out.println(p.getDate());
        return "Added successfully";
    }

    @GetMapping("/view")
    public String viewPatient(){
        return "Patient view successful";
    }

}
