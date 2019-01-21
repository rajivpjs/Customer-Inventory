package com.rppjs.customer.online.portal.configuration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginServiceConfigurationTest {

    private LoginServiceConfiguration loginServiceConfiguration =
            new LoginServiceConfiguration();

    @Test
    public void testSimpleLoginService_expectsSimpleLoginService() {
        assertNotNull(loginServiceConfiguration.simpleLoginService());
    }
}