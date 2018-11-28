package com.rppjs.customer.endpoints;

import com.rppjs.customer.dtos.RegistrationRequestDTO;
import com.rppjs.customer.dtos.RegistrationResponseDTO;
import com.rppjs.customer.dtos.mapper.UserMapper;
import com.rppjs.customer.entities.User;
import com.rppjs.customer.repository.CustomerRepository;
import com.rppjs.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationEndpoint {

    private UserMapper userMapper;
    private UserRepository userRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public RegistrationEndpoint(UserMapper userMapper, UserRepository userRepository, CustomerRepository customerRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponseDTO> registerCustomer(@RequestBody RegistrationRequestDTO req) {
        User user = userMapper.registrationRequestToUser(req);

        customerRepository.save(user.getCustomer());
        userRepository.save(user);

        RegistrationResponseDTO responseDTO = userMapper.userToRegistrationResponse(user);
        return new ResponseEntity<RegistrationResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
