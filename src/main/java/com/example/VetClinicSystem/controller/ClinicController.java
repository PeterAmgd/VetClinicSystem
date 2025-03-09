package com.example.VetClinicSystem.controller;

import com.example.VetClinicSystem.model.Clinic;
import com.example.VetClinicSystem.model.Doctor;
import com.example.VetClinicSystem.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("")
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @GetMapping("/{id}")
    public Clinic getClinicById(@PathVariable Long id) {
        return clinicService.getClinicById(id)
                .orElseThrow(() -> new IllegalStateException("Clinic with id " + id + " does not exist"));
    }

    @GetMapping("/{id}/doctors")
    public List<Doctor> getClinicDoctors(@PathVariable Long id) {
        return clinicService.getDoctorsByClinicId(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Clinic>> searchByPhoneOrAddress(@RequestParam String phone, @RequestParam String address) {
        return ResponseEntity.ok(clinicService.searchByPhoneOrAddress(phone, address));
    }

    @PostMapping("")
    public Clinic addClinic(@RequestBody Clinic clinic) {
        return clinicService.addClinic(clinic);
    }

    @PutMapping("")
    public Clinic updateClinic(@RequestBody Clinic clinic) {
        return clinicService.updateClinic(clinic);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
    }

    @PostMapping("/{clinicId}/doctors/{doctorId}")
    public ResponseEntity<Clinic> assignDoctorToClinic(
            @PathVariable Long clinicId,
            @PathVariable Long doctorId) {
        Clinic clinic = clinicService.assignDoctorToClinic(clinicId, doctorId);
        return ResponseEntity.ok(clinic);
    }

    @DeleteMapping("/{clinicId}/doctors/{doctorId}")
    public ResponseEntity<Clinic> deassignDoctorFromClinic(
            @PathVariable Long clinicId,
            @PathVariable Long doctorId) {
        Clinic clinic = clinicService.deassignDoctorFromClinic(clinicId, doctorId);
        return ResponseEntity.ok(clinic);
    }



}
