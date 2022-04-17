package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.City;

import java.util.List;

public interface CityRepository {

    List<City> listAll();

    City search(Long id);

    City save(City city);

    void remove(Long id);
}
