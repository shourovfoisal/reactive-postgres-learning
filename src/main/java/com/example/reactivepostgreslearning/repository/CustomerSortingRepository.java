package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerSortingRepository extends ReactiveSortingRepository<Customer, Integer> {
    Flux<Customer> findAllBy(Pageable pageable);

    Mono<Long> count();
}
