package com.rppjs.customer.repository;

import com.rppjs.customer.configuration.H2Configuration;
import com.rppjs.customer.entities.Customer;
import com.rppjs.customer.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = H2Configuration.class)
public class UserRepositoryTest {

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
        Assert.assertEquals(1, users.size());
        Assert.assertSame(user.getEmailAddress(), users.get(0).getEmailAddress());
    }

}