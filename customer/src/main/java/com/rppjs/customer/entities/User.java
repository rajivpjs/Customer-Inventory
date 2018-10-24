package com.rppjs.customer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class User {

    private String emailAddress;
    private String password;
    @OneToOne
    private Long customerId;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
