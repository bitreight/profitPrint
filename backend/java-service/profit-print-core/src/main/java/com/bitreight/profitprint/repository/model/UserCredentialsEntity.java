package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Entity
@Table(name = "USER_CREDENTIALS")
public class UserCredentialsEntity {

    @Id
    @NonNull
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @NonNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NonNull
    @Column(name = "ROLE", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "userCredentials", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private UserEntity user;

    public enum UserRole {
        ROLE_ADMIN, ROLE_USER
    }
}
