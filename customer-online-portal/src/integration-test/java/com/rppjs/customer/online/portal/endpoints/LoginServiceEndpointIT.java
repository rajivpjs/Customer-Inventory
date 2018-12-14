package com.rppjs.customer.online.portal.endpoints;

import static org.junit.Assert.assertEquals;
import com.rppjs.customer.online.portal.Application;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.dtos.LoginRequestDTO;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {H2Configuration.class, Application.class})
@Transactional
public class LoginServiceEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testLogin_customer_expectsHttpResponse200WithValidJSONBody() throws JSONException {
        String expected = "{email:user@gmail.com}";

        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.email = "user@gmail.com";
        requestDTO.pass = "pass";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(requestDTO, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/login/customer/", entity, String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    }
}