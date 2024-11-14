package com.guarderia.service;

import com.guarderia.modelo.AsignacionZona;
import com.guarderia.modelo.Empleado;
import com.guarderia.modelo.Zona;
import com.guarderia.request.AsignacionZonaForm;
import com.guarderia.request.AsignacionZonaRequest;

import java.util.List;

public interface AsignacionZonaService {

    List<AsignacionZona> findAll();
    AsignacionZona findById(Long id);
    List<AsignacionZona> findByEmpleadoId(Long id);
    List<AsignacionZona> findByZonaId(Long id);
    List<Zona> findAllZonas();
    Empleado findEmpleadoById(Long id);
    AsignacionZona save(AsignacionZonaRequest request);
    AsignacionZona create(AsignacionZonaForm form);
    List<AsignacionZona> saveAll(List<AsignacionZonaRequest> request);
    AsignacionZona update(Long id, AsignacionZonaRequest request);
    AsignacionZona update(AsignacionZona asignacion);
    List<AsignacionZona> updateAll(List<AsignacionZonaRequest> request);
    void deleteById(Long id);

}
