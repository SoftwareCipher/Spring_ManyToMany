package org.boot.spring_many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;

@SpringBootApplication
public class SpringManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringManyApplication.class, args);
        Logger.info("Application started");
    }
}
