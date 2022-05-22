package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.FederativeUnit;
import com.delivery.springfood.domain.repository.FederativeUnitRepository;
import com.delivery.springfood.domain.service.FederativeUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FederativeUnitServiceImpl implements FederativeUnitService {
    private final FederativeUnitRepository federativeUnitRepository;

    @Override
    public List<FederativeUnit> listAll() {
        return federativeUnitRepository.findAll();
    }

    @Override
    public FederativeUnit search(final Long id) {
        return federativeUnitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
    }

    @Override
    public FederativeUnit save(final FederativeUnit federativeUnit) {
        return federativeUnitRepository.save(federativeUnit);
    }

    @Override
    public void remove(final Long id) {
        try {
            federativeUnitRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Não existe um cadastro de Estado com código %d", id));
        } catch (DataIntegrityViolationException d) {
            throw new EntityInUseException(String.format("Estado de código %d não pode ser removido pois está em uso!", id));
        }
    }
}
