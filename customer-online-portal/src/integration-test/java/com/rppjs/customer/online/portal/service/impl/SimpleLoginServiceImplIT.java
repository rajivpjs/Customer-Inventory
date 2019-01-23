package com.rppjs.customer.online.portal.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.configuration.LoginServiceConfiguration;
import com.rppjs.customer.online.portal.configuration.MyConfig;
import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.UserRepository;
import com.rppjs.customer.online.portal.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {H2Configuration.class,
        LoginServiceConfiguration.class, MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class SimpleLoginServiceImplIT {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService simpleLoginService;

    @Test
    public void testLogin_expectsTrue() throws Exception {
        User user = new User();
        user.setEmailAddress("user@gmail.com");
        user.setPassword("123");

        userRepository.save(user);

        assertTrue(simpleLoginService.login("user@gmail.com", "123"));
    }
}
