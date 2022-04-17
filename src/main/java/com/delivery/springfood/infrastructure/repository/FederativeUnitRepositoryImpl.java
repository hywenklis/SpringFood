package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.FederativeUnit;
import com.delivery.springfood.domain.repository.FederativeUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FederativeUnitRepositoryImpl implements FederativeUnitRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<FederativeUnit> listAll() {
        return entityManager.createQuery("from FederativeUnit", FederativeUnit.class).getResultList();
    }

    @Override
    public FederativeUnit search(final Long id) {
        return entityManager.find(FederativeUnit.class, id);
    }

    @Override
    @Transactional
    public FederativeUnit save(final FederativeUnit federativeUnit) {
        return entityManager.merge(federativeUnit);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        FederativeUnit federativeUnit = search(id);

        if (federativeUnit == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(federativeUnit);
    }

}
