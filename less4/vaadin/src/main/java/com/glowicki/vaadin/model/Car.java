package com.glowicki.vaadin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String mark;
    private String model;

    public Car() {
    }

    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }
}
