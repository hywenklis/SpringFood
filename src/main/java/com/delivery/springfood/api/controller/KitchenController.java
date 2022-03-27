package com.delivery.springfood.api.controller;

import java.util.List;

import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.repository.KitchenRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/kitchens")
@RequiredArgsConstructor
public class KitchenController {

    private final KitchenRepository kitchenRepository;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.listAll();
    }
}