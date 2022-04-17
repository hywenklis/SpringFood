package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.Kitchen;
import com.delivery.springfood.domain.repository.KitchenRepository;
import com.delivery.springfood.domain.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final KitchenRepository kitchenRepository;

    @Override
    public List<Kitchen> listAll() {
        return kitchenRepository.listAll();
    }

    @Override
    public Kitchen search(final Long id) {
        return kitchenRepository.search(id);
    }

    @Override
    public Kitchen save(final Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    @Override
    public void remove(final Long id) {
        try {
            kitchenRepository.remove(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Não existe um cadastro de cozinha com código %d", id));
        } catch (DataIntegrityViolationException d) {
            throw new EntityInUseException(String.format("Cozinha de código %d não pode ser removida pois está em uso!", id));
        }
    }
}
