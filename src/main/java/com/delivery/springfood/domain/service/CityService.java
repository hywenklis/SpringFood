package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.City;

import java.util.List;

public interface CityService {

    List<City> listAll();

    City search(Long id);

    City save(City city);

    void remove(Long id);
}
