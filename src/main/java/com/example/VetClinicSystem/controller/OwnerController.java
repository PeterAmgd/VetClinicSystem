package com.example.VetClinicSystem.controller;

import com.example.VetClinicSystem.model.Owner;
import com.example.VetClinicSystem.model.Pet;
import com.example.VetClinicSystem.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    public Optional<Owner> getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> getOwnerPets(@PathVariable Long id) {
        List<Pet> pets = ownerService.getPetsByOwnerId(id);
        return ResponseEntity.ok(pets);
    }

    @PostMapping("")
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    @PutMapping("")
    public Owner updateOwner(@RequestBody Owner owner) {
        return ownerService.updateOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }


}
