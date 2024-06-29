package com.guarderia.service;

import com.guarderia.modelo.Empleado;
import com.guarderia.request.EmpleadoRequest;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    void save(EmpleadoRequest request);
    void update(Long id, EmpleadoRequest request);
    void deleteById(Long id);

}
