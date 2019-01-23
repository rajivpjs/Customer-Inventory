package com.rppjs.customer.online.portal.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class UserConfigurationTest {

    private UserConfiguration userConfiguration;

    @Test
    public void testUserMapper() {
        userConfiguration = new UserConfiguration();
        assertNotNull(userConfiguration.userMapper());
    }
}