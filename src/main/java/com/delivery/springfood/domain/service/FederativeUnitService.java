package com.delivery.springfood.domain.service;

import com.delivery.springfood.domain.model.FederativeUnit;

import java.util.List;

public interface FederativeUnitService {

    List<FederativeUnit> listAll();

    FederativeUnit search(Long id);

    FederativeUnit save(FederativeUnit federativeUnit);

    void remove(Long id);
}
