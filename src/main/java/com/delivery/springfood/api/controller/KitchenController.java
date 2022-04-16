package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.service.KitchenService;
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
    private final KitchenService kitchenService;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> search(@PathVariable Long id) {
        Kitchen kitchen = kitchenService.search(id);

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
        return new ResponseEntity<>(kitchenService.save(kitchen), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> replace(@PathVariable Long id, @RequestBody Kitchen kitchen) {
        Kitchen search = kitchenService.search(id);

        if (search != null) {
            BeanUtils.copyProperties(kitchen, search, "id");
            kitchenService.save(search);
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            kitchenService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}