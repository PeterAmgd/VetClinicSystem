package com.example.VetClinicSystem.service;

import com.example.VetClinicSystem.model.Clinic;
import com.example.VetClinicSystem.model.Doctor;
import com.example.VetClinicSystem.repository.ClinicRepository;
import com.example.VetClinicSystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {
    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository,
                         DoctorRepository doctorRepository) {
        this.clinicRepository = clinicRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Optional<Clinic> getClinicById(Long id) {
        return clinicRepository.findById(id);
    }

    public List<Doctor> getDoctorsByClinicId(Long id) {
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Clinic with id " + id + " does not exist"));
        return clinic.getDoctors();
    }

    public List<Clinic> searchByPhoneOrAddress(String phone, String address) {
        return clinicRepository.findByPhoneOrAddress(phone, address);
    }

    public Clinic addClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public Clinic updateClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }

    public Clinic assignDoctorToClinic(Long clinicId, Long doctorId) {
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new IllegalStateException("Clinic not found with ID: " + clinicId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor not found with ID: " + doctorId));

        // Assign doctor to clinic
        doctor.setClinic(clinic);
        doctorRepository.save(doctor);
        return clinic;
    }

    public Clinic deassignDoctorFromClinic(Long clinicId, Long doctorId) {
        Clinic clinic = clinicRepository.findById(clinicId)
                .orElseThrow(() -> new IllegalStateException("Clinic not found with ID: " + clinicId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor not found with ID: " + doctorId));

        if (!doctor.getClinic().equals(clinic)) {
            throw new IllegalArgumentException("Doctor does not belong to this clinic");
        }

        // De-assign doctor
        doctor.setClinic(null);
        doctorRepository.save(doctor);
        return clinic;
    }

}
