package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> listAll();

    Restaurant search(Long id);

    Restaurant save(Restaurant restaurant);

    String remove(Restaurant restaurant);
}
