package com.bitreight.profitprint.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(exclude = "executor")
@ToString(exclude = "executor")
@Entity
@Table(name = "ExecutorServiceItem")
public class ExecutorServiceItemEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "HighPriorityCoefficient")
    private Double highPriorityCoefficient;

    @Column(name = "LowPriorityCoefficient")
    private Double lowPriorityCoefficient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExecutorId", nullable = false)
    private ExecutorEntity executor;
}
