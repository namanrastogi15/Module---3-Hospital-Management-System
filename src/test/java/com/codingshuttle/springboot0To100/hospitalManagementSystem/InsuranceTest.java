package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.AppointmentService;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.InsuranceService;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance = new Insurance().builder()
                .provider("HDFC_Ergo")
                .policyNumber("HDFC_342")
                .validUntil(LocalDate.of(2030 , 1 ,1 ))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance , 1L);

        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = new Appointment().builder()
                .appoinmentTime(LocalDate.of(2025,1,1))
                .reason("Cancer")
                .build();
        var updatedAppointment = appointmentService.createNewAppointment(appointment , 1L,2L);

        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }
}

