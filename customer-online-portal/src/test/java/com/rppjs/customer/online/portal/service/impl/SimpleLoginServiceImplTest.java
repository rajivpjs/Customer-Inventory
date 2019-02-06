package com.rppjs.customer.online.portal.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.UserRepository;
import com.rppjs.customer.online.portal.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

public class SimpleLoginServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private LoginService loginService = new SimpleLoginServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin_expectsTrue() throws Exception {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setEmailAddress("user@gmail.com");
        user.setPassword("123");
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);
        assertTrue(loginService.login("user@gmail.com", "123"));
        verify(userRepository).findAll();
    }

    @Test
    public void testLogin_expectsFalse() throws Exception {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setEmailAddress("user@gmail.com");
        user.setPassword("1234");
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);
        assertFalse(loginService.login("user@gmail.com", "123"));
        verify(userRepository).findAll();
    }

    @Test
    public void testLogin_expectsException() throws Exception {
        when(userRepository.findAll()).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () ->
                loginService.login("user@gmail.com", "123"));

        verify(userRepository).findAll();
    }
}
