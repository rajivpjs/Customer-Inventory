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
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "customers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "customerId")
@ToString
public class Customer {

    @Id
    @GeneratedValue( generator = "uuid")
    @GenericGenerator(name = "uuid",
            strategy = "uuid")
    private String customerId;
    private String name;
    private String surname;
}
