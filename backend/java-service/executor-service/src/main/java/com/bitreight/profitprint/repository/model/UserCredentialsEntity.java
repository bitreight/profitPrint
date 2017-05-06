package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Entity
@Table(name = "UserCredentials")
public class UserCredentialsEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Login", nullable = false, unique = true)
    private String login;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "UserId", unique = true)
    private UserEntity user;
}
