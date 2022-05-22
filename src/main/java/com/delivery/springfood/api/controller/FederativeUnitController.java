package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.FederativeUnit;
import com.delivery.springfood.domain.service.FederativeUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
public class FederativeUnitController {

    private final FederativeUnitService federativeUnitService;

    @GetMapping
    public List<FederativeUnit> list() {
        return federativeUnitService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FederativeUnit> search(@PathVariable Long id) {
        return ResponseEntity.ok(federativeUnitService.search(id));
    }

    @PostMapping
    public ResponseEntity<FederativeUnit> save(@RequestBody FederativeUnit federativeUnit) {
        return new ResponseEntity<>(federativeUnitService.save(federativeUnit), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FederativeUnit> replace(@PathVariable Long id, @RequestBody FederativeUnit federativeUnit) {
        FederativeUnit search = federativeUnitService.search(id);

        if (search != null) {
            BeanUtils.copyProperties(federativeUnit, search, "id");
            federativeUnitService.save(search);
            return ResponseEntity.ok(search);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            federativeUnitService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
