package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.Kitchen;

import java.util.List;

public interface KitchenRepository {

    List<Kitchen> listAll();

    Kitchen search(Long id);

    Kitchen save(Kitchen kitchen);

    String remove(Kitchen kitchen);
}
