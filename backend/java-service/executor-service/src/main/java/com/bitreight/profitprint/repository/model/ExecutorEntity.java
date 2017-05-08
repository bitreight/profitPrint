package com.bitreight.profitprint.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

/**
 * @author bitreight
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "Executor")
public class ExecutorEntity extends UserEntity {

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "OpenTime", nullable = false)
    private Time openTime;

    @Column(name = "CloseTime", nullable = false)
    private Time closeTime;

    @Column(name = "WebSite")
    private String webSite;
}
