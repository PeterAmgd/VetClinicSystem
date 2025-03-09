package com.example.VetClinicSystem.service;

import com.example.VetClinicSystem.model.Owner;
import com.example.VetClinicSystem.model.Pet;
import com.example.VetClinicSystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(Long id){
        return ownerRepository.findById(id);
    }

    public List<Pet> getPetsByOwnerId(Long id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Owner with id " + id + " does not exist"));
        return owner.getPets();
    }

    public Owner addOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public void deleteOwner(Long id){
        ownerRepository.deleteById(id);
    }

}
