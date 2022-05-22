package com.delivery.springfood.infrastructure.service;

import com.delivery.springfood.domain.exception.EntityInUseException;
import com.delivery.springfood.domain.exception.EntityNotFoundException;
import com.delivery.springfood.domain.model.City;
import com.delivery.springfood.domain.repository.CityRepository;
import com.delivery.springfood.domain.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> listAll() {
        return cityRepository.findAll();
    }

    @Override
    public City search(final Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
    }

    @Override
    public City save(final City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(final Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(String.format("Não existe um cadastro de cidade com código %d", id));
        } catch (DataIntegrityViolationException d) {
            throw new EntityInUseException(String.format("Cidade de código %d não pode ser removida pois está em uso!", id));
        }
    }
}
