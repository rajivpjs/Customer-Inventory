package com.rppjs.customer.online.portal.service;

import com.rppjs.customer.online.portal.entities.User;

public interface LoginService {

    boolean login(String username, String password) throws Exception;
}
