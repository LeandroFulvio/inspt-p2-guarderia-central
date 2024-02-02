package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.request.GarageRequest;

import java.util.List;
import java.util.Optional;

public interface GarageService {

    List<Garage> findAll();
    Optional<Garage> findById(String id);
    List<Garage> findBySocioId(int id);
    void save(GarageRequest request);
    void update(String id, GarageRequest request);
    void deleteById(String id);

}
