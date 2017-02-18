package com.bitreight.profitprint.repository.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author bitreight
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "EXECUTOR")
public class ExecutorEntity extends UserEntity {
}
