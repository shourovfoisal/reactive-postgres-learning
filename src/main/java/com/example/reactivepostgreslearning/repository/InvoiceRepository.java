package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Invoice;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface InvoiceRepository extends ReactiveCrudRepository<Invoice, Integer>, CustomInvoiceRepository {
}
