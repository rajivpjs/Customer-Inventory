package com.rppjs.customer.online.portal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.configuration.MyConfig;
import com.rppjs.customer.online.portal.entities.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {H2Configuration.class, MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class CustomerRepositoryIT {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindAll_returnsTwoSavedCustomers() {
        customerRepository.save(new Customer());
        customerRepository.save(new Customer());
        assertEquals(2, customerRepository.findAll().size());
    }
}