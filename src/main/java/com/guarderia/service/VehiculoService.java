package com.guarderia.service;

import com.guarderia.modelo.Vehiculo;
import com.guarderia.request.VehiculoRequest;


import java.util.List;
import java.util.Optional;

public interface VehiculoService {

    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Long id);
    List<Vehiculo> findBySocioId(Long socioId);
    void save(VehiculoRequest request);
    void update(String id, VehiculoRequest request);
    void deleteById(String id);
}
