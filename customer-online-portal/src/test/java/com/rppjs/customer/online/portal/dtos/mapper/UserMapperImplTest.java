package com.rppjs.customer.online.portal.dtos.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.entities.User;
import org.junit.jupiter.api.Test;

public class UserMapperImplTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    public void testRegistrationRequestToUser_expectsUser() {
        RegistrationRequestDTO req = new RegistrationRequestDTO();
        req.email = "user@gmail.com";
        req.pass = "pass";
        req.firstName = "name";
        req.lastName = "lastName";

        User user = userMapper.registrationRequestToUser(req);

        assertEquals("user@gmail.com", user.getEmailAddress());
        assertEquals("pass", user.getPassword());
        assertEquals("name", user.getCustomer().getName());
        assertEquals("lastName", user.getCustomer().getSurname());
    }

    @Test
    public void testUserToRegistrationResponse_expectsRegistrationResponse() {
        User user = new User();
        user.setEmailAddress("user@gmail.com");

        RegistrationResponseDTO responseDTO = userMapper.userToRegistrationResponse(user);

        assertEquals("user@gmail.com", responseDTO.email);
    }

}