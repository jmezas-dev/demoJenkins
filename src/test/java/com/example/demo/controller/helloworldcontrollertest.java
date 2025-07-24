package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
class helloWorldControllerTests {

    @Autowired
    helloWorldController helloWorldController;

    @Test
    void Home() {
        log.info(helloWorldController.Home());
        assertThat(helloWorldController.Home()).isEqualTo("HEEELP! THE BOSS IS FORCING ME TO DEVELOP USING JAVA!");
    }

    @Test
    void HelloWorld() {
        log.info(helloWorldController.HelloWorld());
        assertThat(helloWorldController.HelloWorld()).isEqualTo("does this work?");
    }
}