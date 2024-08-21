package com.guarderia.service;

import com.guarderia.modelo.TipoVehiculo;
import com.guarderia.repository.TipoVehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoVehiculoServiceImpl implements TipoVehiculoService{

    private final TipoVehiculoRepository repository;

    @Override
    public List<TipoVehiculo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<TipoVehiculo> findAll(Long[] tipos) {
        List<TipoVehiculo> response = new ArrayList<>();
        for (Long t : tipos) {
            response.add(repository.findById(t)
                            .orElseThrow(() ->
                                    new EntityNotFoundException("No se encontro tipo vehiculo con ID: " + t)));
        }
        return response;
    }

    @Override
    public Optional<TipoVehiculo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<TipoVehiculo> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

}
