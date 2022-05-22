package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.repository.KitchenRepository;
import com.delivery.springfood.domain.repository.RestaurantRepository;
import com.delivery.springfood.domain.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final KitchenRepository kitchenRepository;

    @Override
    public List<Restaurant> listAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant search(final Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
    }

    @Override
    public Restaurant save(final Restaurant restaurant) {
        Long id = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
        restaurant.setKitchen(kitchen);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void remove(final Long id) {
        try {
            restaurantRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Não existe um cadastro de restaurante com código %d", id));
        } catch (DataIntegrityViolationException d) {
            throw new EntityInUseException(String.format("Restaurante de código %d não pode ser removido pois está em uso!", id));
        }
    }

    @Override
    public void merge(Map<String, Object> originFields, Restaurant restaurant) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurant restaurantOrigin = objectMapper.convertValue(originFields, Restaurant.class);
        originFields.forEach((nameProperties, valueProperties) -> {
            Field field = ReflectionUtils.findField(Restaurant.class, nameProperties);
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, restaurantOrigin);
            ReflectionUtils.setField(field, restaurant, newValue);
        });
    }
}
