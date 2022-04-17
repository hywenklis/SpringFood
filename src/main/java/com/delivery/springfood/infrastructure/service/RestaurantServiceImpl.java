package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import com.delivery.springfood.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> listAll() {
        return restaurantRepository.listAll();
    }

    @Override
    public Restaurant search(Long id) {
        return restaurantRepository.search(id);
    }
}
