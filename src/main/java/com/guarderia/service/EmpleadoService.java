package com.guarderia.service;

import com.guarderia.modelo.Empleado;
import com.guarderia.request.EmpleadoForm;
import com.guarderia.request.EmpleadoRequest;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAll();
    Empleado findById(Long id);
    Empleado save(EmpleadoRequest request);
    Empleado save(EmpleadoForm request);
    Empleado update(Long id, EmpleadoRequest request);
    void deleteById(Long id);

}
