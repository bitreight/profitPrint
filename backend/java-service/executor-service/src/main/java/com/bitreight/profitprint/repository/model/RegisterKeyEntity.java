package com.bitreight.profitprint.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(exclude = "executor")
@ToString(exclude = "executor")
@Entity
@Table(name = "RegisterKey")
public class RegisterKeyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExecutorId", unique = true)
    private ExecutorEntity executor;
}
