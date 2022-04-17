package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.KitchenRepository;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import com.delivery.springfood.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Restaurant search(final Long id) {
        return restaurantRepository.search(id);
    }

    @Override
    public Restaurant save(final Restaurant restaurant) {
        Long id = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.search(id);

        if (kitchen == null) {
            throw new EntityNotFoundException(String.format("Não existe cadastro de cozinha com o código %d ", id));
        }
        restaurant.setKitchen(kitchen);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void remove(final Long id) {
        try {
            restaurantRepository.remove(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Não existe um cadastro de restaurante com código %d", id));
        } catch (DataIntegrityViolationException d) {
            throw new EntityInUseException(String.format("Restaurante de código %d não pode ser removido pois está em uso!", id));
        }
    }
}
