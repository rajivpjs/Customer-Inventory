package com.rppjs.customer.online.portal.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class UserConfigurationTest {

    @Test
    public void testUserMapper() {
        UserConfiguration userConfiguration = new UserConfiguration();
        assertNotNull(userConfiguration.userMapper());
    }
}
