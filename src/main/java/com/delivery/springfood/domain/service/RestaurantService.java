package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> listAll();
    Restaurant search(Long id);
    Restaurant save(Restaurant restaurant);

    void remove(Long id);
}
