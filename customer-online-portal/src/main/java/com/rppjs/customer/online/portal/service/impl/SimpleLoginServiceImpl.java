package com.rppjs.customer.online.portal.service.impl;

import com.rppjs.customer.online.portal.entities.User;
import com.rppjs.customer.online.portal.repository.UserRepository;
import com.rppjs.customer.online.portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class SimpleLoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) throws Exception {
        try {
            List<User> users = userRepository.findAll();

            return users.stream().anyMatch(user ->
                    user.getEmailAddress().equals(username) &&
                            user.getPassword().equals(password));
        }
        catch(Exception e) {
            throw e;
        }
    }
}
