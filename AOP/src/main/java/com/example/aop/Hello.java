package com.example.aop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Hello {

    @EventListener(ApplicationReadyEvent.class)
    @HelloAspectAdnot
    public String sayHello() {
        System.out.println("Hello");
        return "hello";
    }
}
