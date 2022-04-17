package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.Kitchen;

import java.util.List;

public interface KitchenService {
    List<Kitchen> listAll();

    Kitchen search(Long id);

    Kitchen save(Kitchen kitchen);

    void remove(Long id);
}
