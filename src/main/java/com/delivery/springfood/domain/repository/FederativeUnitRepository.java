package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.FederativeUnit;

import java.util.List;

public interface FederativeUnitRepository {
    List<FederativeUnit> listAll();

    FederativeUnit search(final Long id);

    FederativeUnit save(final FederativeUnit federativeUnit);

    String remove(final FederativeUnit federativeUnit);
}
