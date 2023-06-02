package com.example.netflixconductor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;

@SpringBootTest
class NetflixConductorApplicationTests {

    @Test
    void contextLoads() {
    }

    @TestConfiguration
    @ImportTestcontainers(CommonContainers.class)
    static class Containers {

    }

}
