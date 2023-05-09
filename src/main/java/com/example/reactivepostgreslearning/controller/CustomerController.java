package com.example.reactivepostgreslearning.controller;

import com.example.reactivepostgreslearning.model.Customer;
import com.example.reactivepostgreslearning.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping
    public Flux<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer,
                               @PathVariable Integer id) {
        return repository.findById(id)
                .map(c -> {
                    c.setName(customer.getName());
                    return c;
                })
                .flatMap(repository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id) {
        return repository.deleteById(id);
    }

}
