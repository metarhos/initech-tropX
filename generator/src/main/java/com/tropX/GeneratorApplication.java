package com.tropX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GeneratorApplication {


    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext ctx = SpringApplication.run(GeneratorApplication.class, args);

        Thread.sleep(7000); //or Long.MAX_VALUE
        ctx.close();
    }
}
