package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.request.GarageRequest;
import com.guarderia.request.VehiculoRequest;

import java.util.List;
import java.util.Optional;

public interface GarageService {

    List<Garage> findAll();
    Garage findById(Long id);
    List<Garage> findBySocioId(Long id);
    Garage findByVehiculoId(Long id);
    List<Garage> findByZonaId(Long id);
    Garage create(GarageRequest request);
    Garage save(GarageRequest request);
    List<Garage> saveAll(List<GarageRequest> request);
    Garage update(Long id, GarageRequest request);
    void deleteById(Long id);
    Garage garagePurchase(Long id, Long socioId);
    Garage vehicleIngress(Long id, VehiculoRequest vehiculoRequest);
    Garage vehicleEgress(Long id);

}
