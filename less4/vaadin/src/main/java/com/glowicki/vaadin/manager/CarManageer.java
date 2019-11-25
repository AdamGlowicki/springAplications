package com.glowicki.vaadin.manager;

import com.glowicki.vaadin.model.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Getter
@Setter
public class CarManageer {

    private List<Car> cars;

    public CarManageer() {
        cars = Arrays.asList(
                new Car("BMW", "X2"),
                new Car("Volkswagen", "Golf")
        );
    }
}
