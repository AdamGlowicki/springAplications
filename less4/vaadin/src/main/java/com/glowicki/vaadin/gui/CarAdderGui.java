package com.glowicki.vaadin.gui;

import com.glowicki.vaadin.manager.CarManageer;
import com.glowicki.vaadin.model.Car;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("add-car")
public class CarAdderGui extends VerticalLayout {

    private CarManageer carManageer;

    @Autowired

    public CarAdderGui(CarManageer carManageer) {
        this.carManageer = carManageer;

        TextField textFieldMark = new TextField();
        TextField textFieldModel = new TextField();
        Button buttonAdd = new Button("Add Car");

        textFieldMark.setPlaceholder("mark");
        textFieldModel.setPlaceholder("model");

        buttonAdd.addClickListener( e-> {
            Car car = new Car(textFieldMark.getValue(), textFieldModel.getValue());
            carManageer.getCars().add(car);
        });

        add(textFieldMark, textFieldModel, buttonAdd);
    }
}
