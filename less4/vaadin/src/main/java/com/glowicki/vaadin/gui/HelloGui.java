package com.glowicki.vaadin.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class HelloGui extends VerticalLayout {

    public HelloGui() {
        TextField placeholderField = new TextField();
        placeholderField.setPlaceholder("name");


        Button abacus = new Button("Right",
                new Icon(VaadinIcon.ABACUS));
        abacus.setIconAfterText(true);

        Dialog dialog = new Dialog();
        dialog.add(new Label("Hello"));
        abacus.addClickListener(e -> {
            dialog.open();
        });

        add(placeholderField);
        add(abacus);
    }
}
