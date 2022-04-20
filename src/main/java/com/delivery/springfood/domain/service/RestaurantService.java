package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<Restaurant> listAll();
    Restaurant search(Long id);
    Restaurant save(Restaurant restaurant);
    void remove(Long id);

    void merge(Map<String, Object> originFields, Restaurant restaurant);
}
