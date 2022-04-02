package com.delivery.springfood.domain.repository;

import java.util.List;

import com.delivery.springfood.domain.model.FederativeUnit;

public interface FederativeUnitRepository {
   
    List<FederativeUnit> listAll();

    FederativeUnit search(Long id);

    FederativeUnit save(FederativeUnit federativeUnit);

    String remove(FederativeUnit federativeUnit);
}
