package com.delivery.springfood.api.controller;

import com.delivery.springfood.domain.model.FederativeUnit;
import com.delivery.springfood.domain.repository.FederativeUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
public class FederativeUnitController {
    
    private final FederativeUnitRepository federativeUnitRepository;

    @GetMapping
    public List<FederativeUnit> list() {
        return federativeUnitRepository.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FederativeUnit> search(@PathVariable Long id) {

        FederativeUnit federativeUnit = federativeUnitRepository.search(id);

        if (federativeUnit != null) {
            return ResponseEntity.ok(federativeUnit);
        }
        return ResponseEntity.notFound().build();
    }
}
