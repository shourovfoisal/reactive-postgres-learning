package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Invoice;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends ReactiveCrudRepository<Invoice, Integer>, CustomInvoiceRepository {
}
