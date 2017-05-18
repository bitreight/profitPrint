package com.bitreight.profitprint.repository.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author bitreight
 */
@Data
@Entity
@Table(name = "Document")
public class DocumentEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "Link", nullable = false)
    private String link;
}
