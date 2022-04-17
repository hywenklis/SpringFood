package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.City;
import com.delivery.springfood.domain.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<City> listAll() {
        return entityManager.createQuery("from City", City.class).getResultList();
    }

    @Override
    @Transactional
    public City save(final City city) {
        return entityManager.merge(city);
    }

    @Override
    public City search(final Long id) {
        return entityManager.find(City.class, id);
    }

    @Override
    @Transactional
    public void remove(final Long id) {
        City city = search(id);

        if (city == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(city);
    }
}
