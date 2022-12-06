package com.nest.patientappbackend.controller;

import com.nest.patientappbackend.dao.PatientDao;
import com.nest.patientappbackend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String addPatient(@RequestBody Patient p){
        System.out.println(p.getPatientName());
        System.out.println(p.getPatientNumber());
        System.out.println(p.getDoctorName());
        System.out.println(p.getDate());
        dao.save(p);
        return "Added successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> viewPatient(){
        return (List<Patient>) dao.findAll();
    }

}
