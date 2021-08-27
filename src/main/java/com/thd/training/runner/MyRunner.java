package com.thd.training.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    //SPRING-HANDS-ON_1 point 4
    @Override
    public void run(String... args) throws Exception {
        System.out.println("WELCOME TO THE WORLD OF SPRING");
    }
}
