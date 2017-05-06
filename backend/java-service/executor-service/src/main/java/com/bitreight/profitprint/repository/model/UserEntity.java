package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Data
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;
}
