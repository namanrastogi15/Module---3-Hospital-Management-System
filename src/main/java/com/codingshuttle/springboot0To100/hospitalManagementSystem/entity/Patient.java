package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@ToString
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL) // When will you delete the patient then insurance corresponsing to that patient will be deleted
    @JoinColumn(name = "patient_insurance" , unique = true)
    private Insurance insurance; // Owning side for insurance

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL) // Inverse side for appointments , When will you delete the patinet then appointment corresponsing to that patient will be deleted as well
    private Set<Appointment> appointments = new HashSet<>();

}