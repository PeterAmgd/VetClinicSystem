package com.example.VetClinicSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    private String address;

    @Column(unique = true)
    private String phone;

    private String workingDays;

    private String workingHours;

    @Email
    @Column(unique = true)
    private String email;

    private String socialLinks;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();
}