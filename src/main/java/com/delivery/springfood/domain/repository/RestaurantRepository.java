package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> listAll();

    Restaurant search(final Long id);

    Restaurant save(final Restaurant restaurant);

    String remove(final Restaurant restaurant);
}
