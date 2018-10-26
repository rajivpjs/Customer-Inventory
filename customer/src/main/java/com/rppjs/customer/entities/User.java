package com.rppjs.customer.entities;

import javax.persistence.OneToOne;

public class User {

    @OneToOne(mappedBy = "customerId")
    private Customer customer;
    private String emailAddress;
    private String password;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}