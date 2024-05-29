package com.animal.Animal.Kingdom.repository;

import com.animal.Animal.Kingdom.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long>{
    Animal findByName(String name);
}
