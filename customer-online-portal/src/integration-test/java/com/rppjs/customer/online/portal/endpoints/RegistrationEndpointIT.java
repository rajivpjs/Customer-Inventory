package com.rppjs.customer.online.portal.endpoints;

import static org.junit.Assert.assertEquals;
import com.rppjs.customer.online.portal.Application;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {H2Configuration.class, Application.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class RegistrationEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRegisterCustomer_expectsHttpResponse200WithValidJSONBody() throws JSONException {
        String expected = "{email:user@gmail.com}";

        RegistrationRequestDTO req = new RegistrationRequestDTO();
        req.email = "user@gmail.com";
        req.pass = "pass";
        req.firstName = "RPP";
        req.lastName = "JS";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(req, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/register/customer/", entity, String.class);

        JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}