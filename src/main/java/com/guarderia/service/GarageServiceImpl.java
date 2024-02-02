package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.repository.GarageRepository;
import com.guarderia.request.GarageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repository;

    @Override
    public List<Garage> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Garage> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Garage> findBySocioId(int id) {
        return null;
    }

    @Override
    public void save(GarageRequest request) {

    }

    @Override
    public void update(String id, GarageRequest request) {

    }

    @Override
    public void deleteById(String id) {

    }
}
