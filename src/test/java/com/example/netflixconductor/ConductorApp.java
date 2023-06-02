package com.example.netflixconductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

public class ConductorApp {

    public static void main(String[] args) {
        SpringApplication.from(NetflixConductorApplication::main)
                .with(Containers.class)
                .run(args);
    }

    @ImportTestcontainers(CommonContainers.class)
    static class Containers {

    }
}
