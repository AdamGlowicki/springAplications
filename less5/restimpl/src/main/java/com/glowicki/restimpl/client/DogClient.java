package com.glowicki.restimpl.client;

import com.glowicki.restimpl.api.Dog;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

@Controller
public class DogClient {

    private RestTemplate restTemplate = new RestTemplate();

    public DogClient() {
    }

    private void getDogs() {
        MultiValueMap<String, String> headres = new HttpHeaders();
        headres.add("amount", "2");

        HttpEntity httpEntity = new HttpEntity(headres);

        ResponseEntity<Dog[]> exchange = restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.GET,
                httpEntity,
                Dog[].class);

        Stream.of(exchange.getBody()).forEach(System.out:: println);

    }

    @EventListener(ApplicationReadyEvent.class)
    private void addDogs() {

        Dog dog = new Dog("Krystynka", "ZeSzczecinka");

        HttpEntity httpEntity = new HttpEntity(dog);
        restTemplate.exchange("http://localhost:8080/dogs",
                HttpMethod.POST,
                httpEntity,
                Void.class);


    }

}
