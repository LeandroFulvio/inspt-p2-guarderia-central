package com.guarderia.service;

import com.guarderia.modelo.Vehiculo;
import com.guarderia.request.VehiculoRequest;


import java.util.List;
import java.util.Optional;

public interface VehiculoService {

    List<Vehiculo> findAll();
    Vehiculo findById(Long id);
    List<Vehiculo> findBySocioId(Long socioId);
    Vehiculo save(VehiculoRequest request);
    List<Vehiculo> saveAll(List<VehiculoRequest> request);
    void update(Long id, VehiculoRequest request);
    void deleteById(Long id);
    Vehiculo findOrCreate(VehiculoRequest request);
    Vehiculo removerAsignacion(Long id);

}
