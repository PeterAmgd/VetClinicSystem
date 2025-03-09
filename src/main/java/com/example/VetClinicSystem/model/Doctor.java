package com.example.VetClinicSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NotBlank
    private String phone;

    @Lob
    @Column(nullable = true)
    private String photo;

    private String bio;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    @JsonBackReference
    private Clinic clinic;
}