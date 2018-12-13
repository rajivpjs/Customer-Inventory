package com.rppjs.customer.online.portal.configuration;

import com.rppjs.customer.online.portal.service.LoginService;
import com.rppjs.customer.online.portal.service.impl.SimpleLoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginServiceConfiguration {

    @Bean
    public LoginService simpleLoginService() {
        return new SimpleLoginServiceImpl();
    }
}
