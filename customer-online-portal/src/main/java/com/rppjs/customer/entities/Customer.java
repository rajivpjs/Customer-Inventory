package com.rppjs.customer.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue( generator = "uuid")
    @GenericGenerator(name = "uuid",
            strategy = "uuid")
    private String customerId;
    private String name;
    private String surname;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
