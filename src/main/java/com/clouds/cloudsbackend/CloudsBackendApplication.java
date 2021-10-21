package com.clouds.cloudsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.clouds.cloudsbackend.repo")
public class CloudsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudsBackendApplication.class, args);
    }

}
