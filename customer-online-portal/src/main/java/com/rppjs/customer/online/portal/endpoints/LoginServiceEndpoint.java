package com.rppjs.customer.online.portal.endpoints;

import com.rppjs.customer.online.portal.dtos.LoginRequestDTO;
import com.rppjs.customer.online.portal.dtos.LoginResponseDTO;
import com.rppjs.customer.online.portal.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();

        if (validateRequestDTO(loginRequestDTO)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        loginResponseDTO.email = loginRequestDTO.email;

        if(simpleLoginService.login(loginRequestDTO.email, loginRequestDTO.pass)) {
            return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(loginResponseDTO, HttpStatus.UNAUTHORIZED);
    }

    private boolean validateRequestDTO(@RequestBody LoginRequestDTO loginRequestDTO) {
        if(StringUtils.isEmpty(loginRequestDTO.email) || StringUtils.isEmpty(loginRequestDTO.pass)) {
            return true;
        }
        return false;
    }
}
