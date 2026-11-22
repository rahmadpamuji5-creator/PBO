package com.tikfind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TikFindApplication {
    public static void main(String[] args) {
        SpringApplication.run(TikFindApplication.class, args);
    }
}
