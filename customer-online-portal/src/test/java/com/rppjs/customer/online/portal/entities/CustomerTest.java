package com.rppjs.customer.online.portal.entities;

import static org.junit.Assert.assertEquals;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testEqualsAndHashCode_expectsEqualsAndHashCode() {
        EqualsVerifier.forClass(Customer.class).verify();
    }

    @Test
    public void testToString_expectsValidToStringFormat() {
        Customer customer = new Customer("id", "FirstName", "Surname");
        String expected = "Customer(customerId=" + customer.getCustomerId() + ", " + "name=" + customer.getName() +
                ", surname=" + customer.getSurname() + ")";
        assertEquals(expected, customer.toString());
    }
}