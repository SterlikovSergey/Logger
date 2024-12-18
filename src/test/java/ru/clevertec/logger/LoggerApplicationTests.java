package ru.clevertec.logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootTest(classes = LoggerApplicationTests.DummyApplication.class)
class LoggerApplicationTests {

    @SpringBootApplication
    static class DummyApplication {
    }

    @Test
    void contextLoads() {
    }
}
