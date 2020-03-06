package com.alienvault.demo;

import com.alienvault.demo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SalesforceappApplicationTests {

    @Test
    void contextLoads() throws IOException {
        UserController ob=new UserController();
        ob.getUserInfo();
    }

}
