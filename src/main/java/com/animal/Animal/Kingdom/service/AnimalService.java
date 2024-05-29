package com.animal.Animal.Kingdom.service;

import com.animal.Animal.Kingdom.model.Animal;
import com.animal.Animal.Kingdom.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    //Read
    public Animal getAnimalByName(String name) {
        return animalRepository.findByName(name);

    }
    //Create
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Update
    public Animal updateAnimal(Long id, Animal animalDetails) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        animal.setName(animalDetails.getName());
        animal.setSpecies(animalDetails.getSpecies());
        animal.setHabitat(animalDetails.getHabitat());
        animal.setDiet(animalDetails.getDiet());
        return animalRepository.save(animal);
    }

    // Delete
    public void deleteAnimal(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        animalRepository.delete(animal);
    }
}
