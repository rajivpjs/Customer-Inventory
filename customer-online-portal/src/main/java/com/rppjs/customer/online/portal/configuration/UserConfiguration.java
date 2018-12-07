package com.rppjs.customer.online.portal.configuration;

import com.rppjs.customer.online.portal.dtos.mapper.UserMapper;
import com.rppjs.customer.online.portal.dtos.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
