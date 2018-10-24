package com.example.service;

import com.example.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    List<Pet> petStore = new ArrayList();

    public boolean  addPet(Pet pet) {
        return petStore.add(pet);
    }

    public List<Pet> getAllPets() {
        return petStore;
    }

    public boolean deletePet(int id) {
        if (!petStore.isEmpty()) {
            return petStore.removeIf(pet -> pet.getId() == id);
        } else return false;
    }

    public Pet getPet(int id) {
        Optional<Pet> optionalPet = petStore.stream().filter(pet -> pet.getId() == id).findFirst();
        return optionalPet.get();
    }
}
