package com.nest.patientappbackend.dao;

import com.nest.patientappbackend.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
}
