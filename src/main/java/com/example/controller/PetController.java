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
@RequestMapping("/pets")
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
        else return "adding new Pet failed !!!";
    }

    @PutMapping("{petId}")
    public String updatePet(@PathVariable int petId, @RequestBody Pet pet) {
         if(petService.updatePet(petId, pet)) return "Pet details Updated successfully";
         else return "update failed!!!";
    }

    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable int petId) {
        if (petService.deletePet(petId)) return "Pet deleted successfully";
        else return "deleting the pet failed !!!";
    }
}
