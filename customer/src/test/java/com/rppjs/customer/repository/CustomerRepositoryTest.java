package com.rppjs.customer.repository;

import static org.junit.Assert.*;
import com.rppjs.customer.configuration.H2Configuration;
import com.rppjs.customer.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = H2Configuration.class)
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindAll_returnsTwoSavedCustomers() {
        customerRepository.save(new Customer());
        customerRepository.save(new Customer());
        assertEquals(2, customerRepository.findAll().size());
    }
}