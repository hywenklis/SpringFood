package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.Payment;

import java.util.List;

public interface PaymentRepository {
    
    List<Payment> listAll();

    Payment search(Long id);

    Payment save(Payment payment);

    void remove(Long id);
}
