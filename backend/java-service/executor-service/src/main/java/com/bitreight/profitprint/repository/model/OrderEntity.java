package com.bitreight.profitprint.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(exclude = {"customer", "executor", "executorServiceItem", "documents"})
@ToString(exclude = {"customer", "executor", "executorServiceItem", "documents"})
@Entity
@Table(name = "\"Order\"")
public class OrderEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Count", nullable = false)
    private Integer count;

    @Column(name = "Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "CustomerComment")
    private String customerComment;

    @Column(name = "Priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderPriority priority;

    @Column(name = "State", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExecutorId", nullable = false)
    private ExecutorEntity executor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExecutorServiceItemId", nullable = false)
    private ExecutorServiceItemEntity executorServiceItem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "OrderDocument",
               joinColumns = @JoinColumn(name = "OrderId", nullable = false),
               inverseJoinColumns = @JoinColumn(name = "DocumentId", nullable = false))
    private List<DocumentEntity> documents;
}
