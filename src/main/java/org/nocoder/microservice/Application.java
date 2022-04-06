package org.nocoder.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="org.nocoder.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
