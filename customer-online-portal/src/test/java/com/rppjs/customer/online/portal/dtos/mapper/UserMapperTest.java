package com.rppjs.customer.online.portal.dtos.mapper;

import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.entities.User;
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

    @Test
    public void testUserToRegistrationResponse_expectsRegistrationResponse() {
        User user = new User();
        user.setEmailAddress("user@gmail.com");

        RegistrationResponseDTO responseDTO = userMapper.userToRegistrationResponse(user);

        Assert.assertEquals("user@gmail.com", responseDTO.email);
    }

}