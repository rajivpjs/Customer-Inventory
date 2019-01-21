package com.rppjs.customer.online.portal.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.dtos.mapper.UserMapper;
import com.rppjs.customer.online.portal.entities.Customer;
import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.CustomerRepository;
import com.rppjs.customer.online.portal.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class RegistrationEndpointTest {

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private RegistrationEndpoint registrationEndpoint = new RegistrationEndpoint(userMapper, userRepository, customerRepository);

    @BeforeAll
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

        when(userMapper.registrationRequestToUser(req)).thenReturn(user);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.userToRegistrationResponse(user)).thenReturn(expectedResponseDTO);
        
        ResponseEntity<RegistrationResponseDTO> responseDTO = registrationEndpoint.registerCustomer(req);
        assertEquals(200, responseDTO.getStatusCodeValue());
        assertEquals(expectedResponseDTO.email, responseDTO.getBody().email);

        verify(userMapper).registrationRequestToUser(any(RegistrationRequestDTO.class));
        verify(customerRepository).save(any(Customer.class));
        verify(userRepository).save(any(User.class));
        verify(userMapper).userToRegistrationResponse(any(User.class));
    }

    @Test
    public void testRegisterCustomer_expectsHttpResponse400() {
        ResponseEntity<RegistrationResponseDTO> responseEntity = registrationEndpoint.
                registerCustomer(new RegistrationRequestDTO());

        assertEquals(400, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());
    }

}