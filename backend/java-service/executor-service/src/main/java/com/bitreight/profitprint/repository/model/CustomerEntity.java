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
@Table(name = "CUSTOMER")
public class CustomerEntity extends UserEntity {

    @Column(name = "FNAME")
    private String fname;

    @Column(name = "LNAME")
    private String lname;
}
