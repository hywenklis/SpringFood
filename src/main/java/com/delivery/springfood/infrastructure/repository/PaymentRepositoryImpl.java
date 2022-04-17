package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.Payment;
import com.delivery.springfood.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public void remove(Long id) {
        Payment payment = search(id);

        if (payment == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(payment);
    }

    @Override
    public Payment search(final Long id) {
        return entityManager.find(Payment.class, id);
    }
}
