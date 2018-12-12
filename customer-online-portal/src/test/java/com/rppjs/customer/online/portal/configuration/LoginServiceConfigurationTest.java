package com.rppjs.customer.online.portal.configuration;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class LoginServiceConfigurationTest {

    private LoginServiceConfiguration loginServiceConfiguration =
            new LoginServiceConfiguration();

    @Test
    public void testSimpleLoginService_expectsSimpleLoginService() {
        assertNotNull(loginServiceConfiguration.simpleLoginService());
    }
}