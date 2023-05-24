package com.example.reactivepostgreslearning.repository;

import com.example.reactivepostgreslearning.mapper.InvoiceMapper;
import com.example.reactivepostgreslearning.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class CustomInvoiceRepositoryImpl implements CustomInvoiceRepository {

    private final DatabaseClient client;

    public Flux<Invoice> findAllInvoicesWithCustomer (int customerId) {
        String query = "SELECT \n" +
                "c.id AS customer_id, c.name AS customer_name, i.id AS invoice_id, i.invoice_no \n" +
                "FROM invoice i \n" +
                "INNER JOIN customer c \n" +
                "ON c.id=i.customer_id\n" +
                "WHERE c.id=:customerId";

        InvoiceMapper mapper = new InvoiceMapper();

        Flux<Invoice> result = client.sql(query)
                .bind("customerId", customerId)
                .map(mapper::apply)
                .all();

        return result;
    }
}
