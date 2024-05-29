package com.animal.Animal.Kingdom.controller;

import com.animal.Animal.Kingdom.model.Animal;
import com.animal.Animal.Kingdom.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/animal")
public class AnimalController {
   @Autowired
   private AnimalService animalService;

   // Create
   @PostMapping
   public Animal createAnimal(@RequestBody Animal animal) {
      return animalService.saveAnimal(animal);
   }

   // Read all
   @GetMapping
   public List<Animal> getAllAnimals() {
      return animalService.getAllAnimals();
   }

   // Read by name
   @GetMapping("/{name}")
   public Animal getAnimalByName(@PathVariable String name) {
      return animalService.getAnimalByName(name);
   }

   // Read by ID
   @GetMapping("/id/{id}")
   public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {nal<Animal> animal = animalService.getAnimalById(id);
      return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   // Update
   @PutMapping("/{id}")
   public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
      Animal updatedAnimal = animalService.updateAnimal(id, animalDetails);
      return ResponseEntity.ok(updatedAnimal);
   }

   // Delete
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
      animalService.deleteAnimal(id);
      return ResponseEntity.noContent().build();
   }



}
