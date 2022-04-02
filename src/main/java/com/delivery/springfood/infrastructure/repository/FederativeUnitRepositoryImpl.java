package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.FederativeUnit;
import com.delivery.springfood.domain.repository.FederativeUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FederativeUnitRepositoryImpl implements FederativeUnitRepository {

    private final EntityManager entityManager;

    @Override
    public List<FederativeUnit> listAll() {
        return entityManager.createQuery("from FederativeUnit", FederativeUnit.class).getResultList();
    }

    @Override
    public FederativeUnit search(Long id) {
        return entityManager.find(FederativeUnit.class, id);
    }

    @Override
    public FederativeUnit save(FederativeUnit federativeUnit) {
        return entityManager.merge(federativeUnit);
    }

    @Override
    public String remove(FederativeUnit federativeUnit) {
        federativeUnit = search(federativeUnit.getId());
        entityManager.remove(federativeUnit);
        return federativeUnit.getName();
    }
}
