package com.example.reactivepostgreslearning.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
public class Invoice {

    @Id
    private Integer id;

    @Column
    private String invoiceNo;

    private Customer customer;

}
