package com.example.lesson4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lesson4Application {




    public static void main(String[] args) {
        ApplicationContext cntx = SpringApplication.run(Lesson4Application.class, args);

        AppStart appStart = cntx.getBean(AppStart.class);

        appStart.Start();
        //System.out.println(strings);
    }

}
