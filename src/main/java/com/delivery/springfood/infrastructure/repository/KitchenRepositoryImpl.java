package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Kitchen> listAll() {
        return entityManager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Override
    @Transactional
    public Kitchen save(final Kitchen kitchen) {
        return entityManager.merge(kitchen);
    }

    @Override
    public Kitchen search(final Long id) {
        return entityManager.find(Kitchen.class, id);
    }

    @Override
    @Transactional
    public void remove(final Long id) {
        Kitchen kitchen = search(id);

        if (kitchen == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(kitchen);
    }
}
