package com.rppjs.customer.online.portal.endpoints;

import com.rppjs.customer.online.portal.dtos.LoginRequestDTO;
import com.rppjs.customer.online.portal.dtos.LoginResponseDTO;
import com.rppjs.customer.online.portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginServiceEndpoint {

    @Autowired
    private LoginService simpleLoginService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return null;
    }
}
