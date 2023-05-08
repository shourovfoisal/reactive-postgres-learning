package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
