package com.glowicki.restimpl.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogApi {

    private List<Dog> dogs;

    public DogApi() {
        this.dogs = new ArrayList<>();
                dogs.add(new Dog("Jerzy", "Beettle"));
                dogs.add(new Dog("Ryszard", "Rattlerek"));
                dogs.add(new Dog("Heniek", "Owczrek"));
    }

    @GetMapping
    public List<Dog> get(@RequestHeader int amount) {
        return dogs.subList(0, amount);
    }

    @PostMapping
    public void add(@RequestBody Dog dog) {
        dogs.add(dog);
    }
}
