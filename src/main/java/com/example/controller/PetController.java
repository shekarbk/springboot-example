package com.example.controller;

import com.example.model.Pet;
import com.example.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Pet Controller class
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("{petId}")
    public Pet getPet(@PathVariable int petId) {
        return petService.getPet(petId);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping
    public String createPet(@RequestBody Pet pet) {
        if (petService.addPet(pet)) return "New Pet created successfully";
        else return "New Pet failed to create !!!";
    }

    @PutMapping
    public String updatePet(@RequestBody Pet pet) {
        return "Pet details Updated successfully";
    }

    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable int petId) {
        if (petService.deletePet(petId)) return "Pet deleted successfully";
        else return "deleting the pet failed !!!";
    }
}
