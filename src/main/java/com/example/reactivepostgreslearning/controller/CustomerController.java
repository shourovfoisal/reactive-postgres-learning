package com.example.reactivepostgreslearning.controller;

import com.example.reactivepostgreslearning.model.Customer;
import com.example.reactivepostgreslearning.repository.CustomerRepository;
import com.example.reactivepostgreslearning.repository.CustomerSortingRepository;
import com.example.reactivepostgreslearning.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;
    private final CustomerService service;

    @GetMapping
    public Flux<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping("/all/paginated")
    public Mono<Page<Customer>> getCustomersPaginated(@RequestParam("page") int page,
                                                      @RequestParam("size") int size) {
        return service.getCustomersPaginated(page, size);
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
