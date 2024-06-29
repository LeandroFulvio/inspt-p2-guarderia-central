package com.guarderia.service;

import com.guarderia.modelo.Empleado;
import com.guarderia.request.EmpleadoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpeladoServiceImpl implements EmpleadoService{


    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(EmpleadoRequest request) {

    }

    @Override
    public void update(Long id, EmpleadoRequest request) {

    }

    @Override
    public void deleteById(Long id) {

    }

}
