package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Getter
@Setter
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ADDITIONAL")
    private String additional;
}
