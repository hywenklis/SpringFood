package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> list() {
        return ResponseEntity.ok(restaurantService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> search(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.search(id);

        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
        try {
            return new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
