package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.Kitchen;

import java.util.List;

public interface KitchenService {
    List<Kitchen> listAll();

    Kitchen search(final Long id);

    Kitchen save(final Kitchen kitchen);

    void remove(final Long id);
}
