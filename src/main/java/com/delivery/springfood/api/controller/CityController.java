package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.City;
import com.delivery.springfood.domain.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> list() {
        return cityService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> search(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.search(id));
    }

    @PostMapping
    public ResponseEntity<City> save(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> replace(@PathVariable Long id, @RequestBody City city) {
        City search = cityService.search(id);

        if (search != null) {
            BeanUtils.copyProperties(city, search, "id");
            cityService.save(search);
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            cityService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
