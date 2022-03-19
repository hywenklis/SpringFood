package com.delivery.springfood.jpa;

import com.delivery.springfood.domain.model.Kitchen;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RegisterKitchen {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Kitchen> listAll() {
        return entityManager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }
}
