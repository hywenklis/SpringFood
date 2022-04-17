package com.delivery.springfood.infrastructure.repository;

import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Restaurant> listAll() {
        return entityManager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Restaurant search(final Long id) {
        return entityManager.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public Restaurant save(final Restaurant restaurant) {
        return entityManager.merge(restaurant);
    }

    @Override
    public void remove(Long id) {
        Restaurant restaurant = search(id);

        if (restaurant == null) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(restaurant);
    }
}
