package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "Customer")
public class CustomerEntity extends UserEntity {

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;
}
