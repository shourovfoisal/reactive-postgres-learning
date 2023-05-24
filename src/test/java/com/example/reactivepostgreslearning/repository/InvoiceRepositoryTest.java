package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.model.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository repository;
    @Test
    public void getInvoices() {
        Flux<Invoice> allInvoicesWithCustomer = repository.findAllInvoicesWithCustomer(4);
        List<Invoice> list = allInvoicesWithCustomer.toStream().toList();
        System.out.println("list = " + list);
    }
}