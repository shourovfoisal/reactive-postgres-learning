package com.example.reactivepostgreslearning.mapper;

import com.example.reactivepostgreslearning.model.Customer;
import com.example.reactivepostgreslearning.model.Invoice;
import io.r2dbc.spi.Row;

import java.util.function.BiFunction;

public class InvoiceMapper implements BiFunction<Row, Object, Invoice> {

    @Override
    public Invoice apply(Row row, Object o) {

        Integer customerId = row.get("customer_id", Integer.class);
        String customerName = row.get("customer_name", String.class);
        Integer customerAge = row.get("customer_age", Integer.class);
        Integer invoiceId = row.get("invoice_id", Integer.class);
        String invoiceNo = row.get("invoice_no", String.class);

        Customer customer = Customer
                .builder()
                .name(customerName)
                .id(customerId)
                .age(customerAge)
                .build();

        return Invoice
                .builder()
                .id(invoiceId)
                .invoiceNo(invoiceNo)
                .customer(customer)
                .build();
    }
}
