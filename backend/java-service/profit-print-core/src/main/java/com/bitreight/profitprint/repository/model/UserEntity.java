package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = "userCredentials")
@ToString(exclude = "userCredentials")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_CREDENTIALS_ID", nullable = false)
    private UserCredentialsEntity userCredentials;
}
