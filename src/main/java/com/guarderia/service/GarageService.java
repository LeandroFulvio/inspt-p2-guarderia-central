package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.request.GarageRequest;

import java.util.List;
import java.util.Optional;

public interface GarageService {

    List<Garage> findAll();
    Optional<Garage> findById(Long id);
    List<Garage> findBySocioId(Long id);
    void save(GarageRequest request);
    void update(Long id, GarageRequest request);
    void deleteById(Long id);

}
