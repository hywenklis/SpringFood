package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.Payment;

import java.util.List;

public interface PaymentRepository {
    
    List<Payment> listAll();

    Payment search(final Long id);

    Payment save(final Payment payment);

    String remove(final Payment payment);
}
