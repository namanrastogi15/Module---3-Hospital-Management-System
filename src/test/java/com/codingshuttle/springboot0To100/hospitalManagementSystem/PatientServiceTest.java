package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();
//
//        for(var p: patientList) {
//            System.out.println(p);
//        }

//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConConcrete();

//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//        for (var p : patientList) {
//            System.out.println(p);
//        }

        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
        System.out.println(rowsAffected);
    }
}

