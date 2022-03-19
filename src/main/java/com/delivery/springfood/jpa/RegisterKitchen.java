package com.delivery.springfood.jpa;

import com.delivery.springfood.domain.model.Kitchen;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RegisterKitchen {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Kitchen> listAll() {
        return entityManager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Transactional
    public Kitchen add(Kitchen kitchen) {
        return entityManager.merge(kitchen);
    }
}
