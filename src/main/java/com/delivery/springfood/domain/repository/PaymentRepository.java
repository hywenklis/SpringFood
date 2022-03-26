package com.delivery.springfood.domain.repository;

import java.util.List;

import com.delivery.springfood.domain.model.Payment;

public interface PaymentRepository {
    
    List<Payment> listAll();

    Payment search(Long id);

    Payment save(Payment payment);

    String remove(Payment payment);
}
