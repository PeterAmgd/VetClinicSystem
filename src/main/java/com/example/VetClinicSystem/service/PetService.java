package com.example.VetClinicSystem.service;

import com.example.VetClinicSystem.model.Pet;
import com.example.VetClinicSystem.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {

        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet addPet(Pet pet , MultipartFile file) {
        if (file != null) {
            pet.setPhoto_path(file.getOriginalFilename());
        }
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet) {

        return petRepository.save(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

}
