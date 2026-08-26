package com.codingshuttle.springboot0To100.hospitalManagementSystem.repository;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id , p.name name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.CPatientInfo (p.id, p.name) " +
    "from Patient p")
    List<CPatientInfo> getAllPatientsInfoConConcrete();

    @Query( "select new  com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStats(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup order by count(p) desc")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("update Patient p set p.name =:name where  p.id =:id" )
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}