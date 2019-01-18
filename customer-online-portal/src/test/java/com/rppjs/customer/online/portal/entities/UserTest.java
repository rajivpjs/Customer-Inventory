package com.rppjs.customer.online.portal.entities;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;


public class UserTest {

    @Test
    public void testEqualsAndHashCode_expectsEqualsAndHashCode() {
        EqualsVerifier.forClass(User.class).verify();
    }

    @Test
    public void testToString_expectsValidToStringFormat() {
        Customer customer = new Customer("id", "FirstName", "Surname");
        User user = new User("test@gmail.com", customer, "");

        String expected = "User(emailAddress=" + user.getEmailAddress() + ", customer=" + customer + ")";
        assertEquals(expected, user.toString());
    }
}