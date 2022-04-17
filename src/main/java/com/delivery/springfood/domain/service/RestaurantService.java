package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> listAll();
    Restaurant search(final Long id);
}
