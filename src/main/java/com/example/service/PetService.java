package com.example.service;

import com.example.model.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    List<Pet> petStore = new ArrayList();

    PetService(){
        Pet p1 = new Pet();
        p1.setId(1);
        p1.setColor("white");
        p1.setName("Lilly");
        p1.setAge(2);

        Pet p2 = new Pet();
        p2.setId(2);
        p2.setColor("black");
        p2.setName("Lucy");
        p2.setAge(5);

        Pet p3 = new Pet();
        p3.setId(3);
        p3.setColor("brown");
        p3.setName("Tom");
        p3.setAge(10);

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
        Optional<Pet> optionalPet = petStore.stream().filter(pet -> pet.getId() == id).findFirst();
        return optionalPet.get();
    }

    public boolean updatePet(int id, Pet newPet) {
        if (!petStore.isEmpty()) {
            if (petStore.removeIf(p -> p.getId() == id)) return petStore.add(newPet);
        }
        return false;
    }
}
