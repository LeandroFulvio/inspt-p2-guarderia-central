package com.guarderia.service;

import com.guarderia.modelo.AsignacionZona;
import com.guarderia.request.AsignacionZonaRequest;

import java.util.List;

public interface AsignacionZonaService {

    List<AsignacionZona> findAll();
    AsignacionZona findById(Long id);
    List<AsignacionZona> findByEmpleadoId(Long id);
    List<AsignacionZona> findByZonaId(Long id);
    AsignacionZona save(AsignacionZonaRequest request);
    List<AsignacionZona> saveAll(List<AsignacionZonaRequest> request);

    AsignacionZona update(Long id, AsignacionZonaRequest request);
    List<AsignacionZona> updateAll(List<AsignacionZonaRequest> request);
    void deleteById(Long id);

}
