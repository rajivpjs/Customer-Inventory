package com.rppjs.customer.online.portal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.rppjs.customer.online.portal.configuration.H2Configuration;
import com.rppjs.customer.online.portal.configuration.MyConfig;
import com.rppjs.customer.online.portal.entities.Customer;
import com.rppjs.customer.online.portal.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {H2Configuration.class, MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindAll_returnsSavedUser() {
        Customer customer = new Customer();
        customerRepository.save(customer);

        User user = new User();
        user.setEmailAddress("user@gmail.com");
        user.setPassword("Password");
        user.setCustomer(customer);
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        assertEquals(1, users.size());
        assertSame(user.getEmailAddress(), users.get(0).getEmailAddress());
    }
}