package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Customer;
import com.example.reactivepostgreslearning.model.Invoice;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;

public interface CustomInvoiceRepository {
    Flux<Invoice> findAllInvoicesWithCustomer (int customerId);
}
