package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.KitchenRepository;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import com.delivery.springfood.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final KitchenRepository kitchenRepository;

    @Override
    public List<Restaurant> listAll() {
        return restaurantRepository.listAll();
    }

    @Override
    public Restaurant search(Long id) {
        return restaurantRepository.search(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Long id = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.search(id);

        if (kitchen == null) {
            throw new EntityNotFoundException(String.format("Não existe cadastro de cozinha com o código %d ", id));
        }
        restaurant.setKitchen(kitchen);
        return restaurantRepository.save(restaurant);
    }
}
