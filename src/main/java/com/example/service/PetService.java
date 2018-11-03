package com.example.service;

import com.example.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    List<Pet> petStore = new ArrayList();

    PetService() {
        Pet p1 = new Pet(1, "Lilly", 2, "white");
        Pet p2 = new Pet(2, "Lucy", 4, "black");
        Pet p3 = new Pet(3, "Tom", 10, "brown");
        petStore.add(p1);
        petStore.add(p2);
        petStore.add(p3);
    }

    public boolean addPet(Pet pet) {
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
//        Optional<Pet> optionalPet = petStore.stream().filter(pet -> pet.getId() == id).findFirst();
        return petStore.stream().filter(pet -> pet.getId() == id).findFirst().get();
    }

    public boolean updatePet(int id, Pet newPet) {
        if (!petStore.isEmpty()) {
            for (Pet p : petStore) {
                if (p.getId() == id) {
                    petStore.set(id, newPet);
                    return true;
                }
            }
        }
//        if (petStore.removeIf(p -> p.getId() == id)) return petStore.add(newPet);
        return false;
    }
}
