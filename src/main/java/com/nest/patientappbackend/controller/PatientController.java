package com.nest.patientappbackend.controller;

import com.nest.patientappbackend.dao.PatientDao;
import com.nest.patientappbackend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> addPatient(@RequestBody Patient p){

        System.out.println(p.getPatientName());
        System.out.println(p.getPatientNumber());
        System.out.println(p.getDoctorName());
        System.out.println(p.getDate());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> viewPatient(){
        return (List<Patient>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path="/search",consumes = "application/json",produces = "application/json")
    public List<Patient> SearchPatient(@RequestBody Patient p){
        String pnumber= String.valueOf(p.getPatientNumber());
        return (List<Patient>) dao.SearchPatient(p.getPatientNumber());

    }


    @CrossOrigin(origins = "*")
    @PostMapping(path="/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> deletePatient(@RequestBody Patient p){
        String pid= String.valueOf(p.getId());
        dao.DeleteEmployee(p.getId());
        HashMap<String,String > map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}
