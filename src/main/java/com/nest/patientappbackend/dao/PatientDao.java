package com.nest.patientappbackend.dao;

import com.nest.patientappbackend.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {

    @Query(value = "SELECT `id`, `date`, `doctor_name`, `patient_name`, `patient_number` FROM `patients` WHERE `patient_number` = :patientNumber",nativeQuery = true)
    List<Patient> SearchPatient(@Param("patientNumber") Integer patientNumber);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patients` WHERE `id` =:id",nativeQuery = true)
    void DeleteEmployee(@Param("id") Integer id);

}
