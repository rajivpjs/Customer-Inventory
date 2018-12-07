package com.rppjs.customer.online.portal.dtos.mapper;

import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.entities.Customer;
import com.rppjs.customer.online.portal.entities.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public User registrationRequestToUser(RegistrationRequestDTO req) {
        User user = new User();
        user.setEmailAddress(req.email);
        user.setPassword(req.pass);

        Customer customer = new Customer();
        customer.setName(req.firstName);
        customer.setSurname(req.lastName);

        user.setCustomer(customer);
        return user;
    }

    @Override
    public RegistrationResponseDTO userToRegistrationResponse(User user) {
        RegistrationResponseDTO responseDTO = new RegistrationResponseDTO();
        responseDTO.email = user.getEmailAddress();
        return responseDTO;
    }
}
