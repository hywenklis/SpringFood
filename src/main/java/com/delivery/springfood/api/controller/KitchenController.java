package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchens")
@RequiredArgsConstructor
public class KitchenController {

    private final KitchenRepository kitchenRepository;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> search(@PathVariable Long id) {
        Kitchen kitchen = kitchenRepository.search(id);

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
        return new ResponseEntity<>(kitchenRepository.save(kitchen), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> replace(@PathVariable Long id, @RequestBody Kitchen kitchen) {
        Kitchen search = kitchenRepository.search(id);

        if (search != null) {
            BeanUtils.copyProperties(kitchen, search, "id");
            kitchenRepository.save(search);
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }
}