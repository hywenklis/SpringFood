package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.Payment;
import com.delivery.springfood.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Payment> listAll() {
        return entityManager.createQuery("from Payment", Payment.class).getResultList();
    }

    @Override
    @Transactional
    public Payment save(final Payment payment) {
        return entityManager.merge(payment);
    }

    @Override
    public Payment search(final Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Override
    @Transactional
    public String remove(Payment payment) {
        payment = search(payment.getId());
        entityManager.remove(payment);
        return payment.getFormatPayment();
    }
}
