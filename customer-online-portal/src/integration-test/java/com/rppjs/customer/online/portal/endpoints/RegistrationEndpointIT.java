package com.rppjs.customer.online.portal.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.configuration.MyConfig;
import com.rppjs.customer.online.portal.configuration.UserConfiguration;
import com.rppjs.customer.online.portal.dtos.RegistrationRequestDTO;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {H2Configuration.class,
                RegistrationEndpoint.class, MyConfig.class,
                UserConfiguration.class})
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