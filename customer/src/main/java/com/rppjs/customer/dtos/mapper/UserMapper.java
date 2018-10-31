package com.rppjs.customer.dtos.mapper;

import com.rppjs.customer.dtos.RegistrationRequestDTO;
import com.rppjs.customer.dtos.RegistrationResponseDTO;
import com.rppjs.customer.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "email", target = "emailAddress"),
            @Mapping(source = "pass", target = "password"),
            @Mapping(source = "firstName", target = "customer.name"),
            @Mapping(source = "lastName", target = "customer.surname")
    })
    User registrationRequestToUser(RegistrationRequestDTO req);

    @Mappings({
            @Mapping(source = "emailAddress", target = "email")
    })
    RegistrationResponseDTO userToRegistrationResponse(User user);
}
