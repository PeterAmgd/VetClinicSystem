package com.example.VetClinicSystem.controller;

import com.example.VetClinicSystem.model.Pet;
import com.example.VetClinicSystem.service.OwnerService;
import com.example.VetClinicSystem.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    private final OwnerService ownerService;

    @Autowired
    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Optional<Pet> getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/add-pet")   // add pet without picture as json request
    public Pet addPetWithOutPic(@RequestBody Pet pet) {
        return petService.addPet(pet, null);
    }

    @PostMapping("/addWithPic") // add pet with picture as form data
    public Pet addPetWithPic(@ModelAttribute Pet pet, @RequestParam("file") MultipartFile file) {
        return petService.addPet(pet, file);
    }


    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }
}
