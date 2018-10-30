package com.rppjs.customer.dtos.mapper;

import com.rppjs.customer.dtos.RegistrationRequestDTO;
import com.rppjs.customer.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void testRegistrationRequestToUser_expectsUser() {
        RegistrationRequestDTO req = new RegistrationRequestDTO();
        req.email = "user@gmail.com";
        req.pass = "pass";
        req.firstName = "name";
        req.lastName = "lastName";

        User user = userMapper.registrationRequestToUser(req);

        Assert.assertEquals("user@gmail.com", user.getEmailAddress());
        Assert.assertEquals("pass", user.getPassword());
        Assert.assertEquals("name", user.getCustomer().getName());
        Assert.assertEquals("lastName", user.getCustomer().getSurname());
    }

}