package com.glowicki.restimpl.client;

import com.glowicki.restimpl.client.AnimalFact;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatController {

    public CatController() {
        RestTemplate template = new RestTemplate();
        AnimalFact[] forObject = template.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2", AnimalFact[].class);

        List<AnimalFact> facts = new ArrayList<>();
        for (AnimalFact fact: forObject) {
            facts.add(fact);
        }

        facts.forEach(System.out::println);
    }
}
