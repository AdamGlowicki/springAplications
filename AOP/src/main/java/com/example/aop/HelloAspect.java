package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

//    @Before("execution(String com.example.aop.Hello.sayHello())") // wywołuje się przed metodą "sayHello" podaje typ, sciezke
//    private void beforHello() {
//        System.out.println("before");
//    }

    @Before("@annotation(HelloAspectAdnot)") // tworze adnotacje np ("@HelloAcceptAdnot"), piszę ją na wykonywanej metodzie ("sayHello()") i wpisauje ją zamiast sciezki w argumencie pomijając znak "@"
    private void beforHello() {
        System.out.println("before");
    }

    @Around("execution(String com.example.aop.Hello.sayHello())")  // blokuje metode "sayHallo" i wprowadza swoją implementację
    private void aroundHello(ProceedingJoinPoint joinPiont) throws Throwable {  // opcjonalnie przekauje w parametrze(ProceedingJoinPoint joinPiont) joinPiont.proceed() wtedy nie ma blokady wykonuje sie najpierw metoda z adnotacją "@Around" a potem implementacja metody z parametru "sayHello()"
        System.out.println("around");
        joinPiont.proceed();
    }

    @After("execution(String com.example.aop.Hello.sayHello())")  // wykonuje się po metodzie wskazanej w porametrze "sayHello()"
    private void afterHello() {
        System.out.println("after");
    }

}
