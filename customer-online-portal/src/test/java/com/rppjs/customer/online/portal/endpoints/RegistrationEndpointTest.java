package com.rppjs.customer.online.portal.endpoints;

import static org.junit.Assert.*;
import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.dtos.mapper.UserMapper;
import com.rppjs.customer.online.portal.entities.Customer;
import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.CustomerRepository;
import com.rppjs.customer.online.portal.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class RegistrationEndpointTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    @Mock
    private UserRepository userRepository;
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private RegistrationEndpoint registrationEndpoint = new RegistrationEndpoint(userMapper, userRepository, customerRepository);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterCustomer_expectsHttpResponse200WithRegistrationResponseDTO() {
        RegistrationRequestDTO req = new RegistrationRequestDTO();
        req.email = "user@gmail.com";
        req.pass = "pass";
        req.firstName = "RPP";
        req.lastName = "JS";

        RegistrationResponseDTO expectedResponseDTO = new RegistrationResponseDTO();
        expectedResponseDTO.email = "user@gmail.com";

        Customer customer = new Customer();
        User user = new User();

        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        
        ResponseEntity<RegistrationResponseDTO> responseDTO = registrationEndpoint.registerCustomer(req);
        assertEquals(200, responseDTO.getStatusCodeValue());
        assertEquals(expectedResponseDTO.email, responseDTO.getBody().email);
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        Mockito.verify(userRepository).save(Mockito.any(User.class));
    }

}