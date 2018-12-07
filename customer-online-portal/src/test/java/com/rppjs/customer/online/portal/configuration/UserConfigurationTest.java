package com.rppjs.customer.online.portal.configuration;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserConfigurationTest {

    private UserConfiguration userConfiguration;

    @Test
    public void testUserMapper() {
        userConfiguration = new UserConfiguration();
        assertNotNull(userConfiguration.userMapper());
    }
}