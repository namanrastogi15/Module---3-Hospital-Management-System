package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@ToString
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
    @ToString.Exclude // To avoid printing patient when appointment is printed
    @JsonIgnore // Prevent it from being used in another DTO
    private Patient patient;

    @ManyToOne //Owning side
    @JoinColumn(nullable = false)
    @ToString.Exclude // To avoid printing doctor when appointment is printed
    @JsonIgnore
    private Doctor doctor;

}
