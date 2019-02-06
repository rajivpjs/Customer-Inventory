package com.rppjs.customer.online.portal.endpoints;

import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import com.rppjs.customer.online.portal.dtos.RegistrationResponseDTO;
import com.rppjs.customer.online.portal.dtos.mapper.UserMapper;
import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.CustomerRepository;
import com.rppjs.customer.online.portal.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
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
        if (validateRequestDTO(req)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.registrationRequestToUser(req);

        customerRepository.save(user.getCustomer());
        userRepository.save(user);

        RegistrationResponseDTO responseDTO = userMapper.userToRegistrationResponse(user);
        return new ResponseEntity<RegistrationResponseDTO>(responseDTO, HttpStatus.OK);
    }

    private boolean validateRequestDTO(@RequestBody RegistrationRequestDTO req) {
        return (StringUtils.isEmpty(req.email) || StringUtils.isEmpty(req.pass)
                || StringUtils.isEmpty(req.firstName)
                || StringUtils.isEmpty(req.lastName));
    }
}
