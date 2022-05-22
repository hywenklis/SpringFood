package com.delivery.springfood.domain.repository;

import com.delivery.springfood.domain.model.FederativeUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FederativeUnitRepository extends JpaRepository<FederativeUnit, Long> {
}
