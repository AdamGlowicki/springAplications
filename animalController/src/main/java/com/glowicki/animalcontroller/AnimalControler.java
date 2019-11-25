package com.glowicki.animalcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AnimalControler {

    public AnimalControler() {
        RestTemplate restTemplate = new RestTemplate();

        AnimalFact animalFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", AnimalFact.class);

        System.out.println(animalFact);
    }

}
