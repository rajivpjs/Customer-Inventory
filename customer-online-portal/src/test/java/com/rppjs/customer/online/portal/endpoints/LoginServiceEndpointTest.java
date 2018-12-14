package com.rppjs.customer.online.portal.endpoints;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import com.rppjs.customer.online.portal.dtos.LoginRequestDTO;
import com.rppjs.customer.online.portal.dtos.LoginResponseDTO;
import com.rppjs.customer.online.portal.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceEndpointTest {

    @Mock
    private LoginService simpleLoginService;

    @InjectMocks
    private static LoginServiceEndpoint loginServiceEndpoint = new
            LoginServiceEndpoint();

    @Test
    public void testLogin_expectsHttpResponse200WithLoginResponseDTO() throws Exception {
        when(simpleLoginService.login(anyString(), anyString())).thenReturn(true);

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.email = "user@gmail.com";
        loginRequestDTO.pass = "pass";

        ResponseEntity<LoginResponseDTO> responseEntity = loginServiceEndpoint.login(loginRequestDTO);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("user@gmail.com", responseEntity.getBody().email);
        verify(simpleLoginService).login(anyString(), anyString());
    }

    @Test
    public void testLogin_expectsHttpResponse401WithLoginResponseDTO() throws Exception {
        when(simpleLoginService.login(anyString(), anyString())).thenReturn(false);

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.email = "user2@gmail.com";
        loginRequestDTO.pass = "pass";

        ResponseEntity<LoginResponseDTO> responseEntity = loginServiceEndpoint.login(loginRequestDTO);
        assertEquals(401, responseEntity.getStatusCodeValue());
        assertEquals("user2@gmail.com", responseEntity.getBody().email);
        verify(simpleLoginService).login(anyString(), anyString());
    }
}