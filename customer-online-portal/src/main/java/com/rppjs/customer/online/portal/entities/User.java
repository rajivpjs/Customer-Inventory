package com.rppjs.customer.online.portal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"emailAddress"})
@ToString(exclude = "password")
public class User {

    @Id
    private String emailAddress;
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Column(name = "passw")
    private String password;
}
