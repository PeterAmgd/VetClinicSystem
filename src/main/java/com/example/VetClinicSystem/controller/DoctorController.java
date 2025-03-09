package com.example.VetClinicSystem.controller;

import com.example.VetClinicSystem.model.Doctor;
import com.example.VetClinicSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id)
                .orElseThrow(() -> new IllegalStateException("Doctor with id " + id + " does not exist"));
    }

    @PostMapping("")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor,null);
    }

    @PostMapping("/addWithPic") // add Doctor with picture as form data
    public Doctor addDoctorWithPic(@ModelAttribute Doctor doctor, @RequestParam("file") MultipartFile file) {
        return doctorService.addDoctor(doctor, file);
    }

    @PutMapping("")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }


}
