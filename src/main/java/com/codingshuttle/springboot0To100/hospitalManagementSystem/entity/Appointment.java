package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate appoinmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne // Owning side
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne //Owning side
    @JoinColumn(nullable = false)
    private Doctor doctor;

}
