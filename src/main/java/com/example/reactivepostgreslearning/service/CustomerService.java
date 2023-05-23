package com.example.reactivepostgreslearning.service;

import com.example.reactivepostgreslearning.model.Customer;
import com.example.reactivepostgreslearning.repository.CustomerSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerSortingRepository sortingRepository;

    public Mono<Page<Customer>> getCustomersPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        final Long[] total = new Long[1];
        sortingRepository.count().subscribe(value -> total[0] =value);
        return sortingRepository
            .findAllBy(pageable)
            .collectList()
            .map(t -> new PageImpl<>(t, pageable, total[0]));
    }

}
