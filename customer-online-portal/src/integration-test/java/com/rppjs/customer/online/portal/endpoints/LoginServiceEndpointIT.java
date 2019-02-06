package com.rppjs.customer.online.portal.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.configuration.LoginServiceConfiguration;
import com.rppjs.customer.online.portal.configuration.MyConfig;
import com.rppjs.customer.online.portal.dtos.LoginRequestDTO;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {H2Configuration.class,
                LoginServiceConfiguration.class, LoginServiceEndpoint.class,
                MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class LoginServiceEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(scripts = "insertUsers.sql")
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
