package com.example.VetClinicSystem.repository;

import com.example.VetClinicSystem.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    List<Clinic> findByPhoneOrAddress(String phone, String address);
}