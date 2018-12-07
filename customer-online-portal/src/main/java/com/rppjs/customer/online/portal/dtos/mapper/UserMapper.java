package com.rppjs.customer.online.portal.dtos.mapper;

import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.entities.User;

public interface UserMapper {

    User registrationRequestToUser(RegistrationRequestDTO req);

    RegistrationResponseDTO userToRegistrationResponse(User user);
}
