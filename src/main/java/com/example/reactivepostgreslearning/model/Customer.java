package com.example.reactivepostgreslearning.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
public class Customer {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;
}
