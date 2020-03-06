package com.alienvault.demo;

import com.alienvault.demo.controller.UserController;
import com.alienvault.demo.entity.TokenInfo;
import com.alienvault.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestSalesForceService {
    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTokenInfoTest() throws IOException {
        TokenInfo object=new TokenInfo();

        when(userService.getToken()).thenReturn(object);

        assertEquals(object.toString(), userController.getToken());
    }
    /*@Test
    public void tokenNotNullTest() throws IOException {
        userService.getQueryResults();
String s1
        when(userService.getToken().getAccess_token()).thenReturn(object);

        assertEquals(object.toString(), userController.getToken());

    }*/
}
