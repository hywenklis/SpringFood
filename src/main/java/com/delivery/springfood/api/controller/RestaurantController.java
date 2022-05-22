package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Restaurant;
import com.delivery.springfood.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return ResponseEntity.ok(restaurantService.search(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
        try {
            return new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            restaurantService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> replace(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        Restaurant search = restaurantService.search(id);

        if (search != null) {
            BeanUtils.copyProperties(restaurant, search, "id");
            restaurantService.save(search);
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        Restaurant restaurant = restaurantService.search(id);

        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }

        restaurantService.merge(fields, restaurant);

        return replace(id, restaurant);
    }
}
