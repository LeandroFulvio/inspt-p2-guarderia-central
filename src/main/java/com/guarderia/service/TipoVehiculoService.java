package com.guarderia.service;

import com.guarderia.modelo.TipoVehiculo;

import java.util.List;
import java.util.Optional;

public interface TipoVehiculoService {

    List<TipoVehiculo> findAll();
    List<TipoVehiculo> findAll(Long[] tipos);
    Optional<TipoVehiculo> findById(Long id);
    Optional<TipoVehiculo> findByNombre(String nombre);

}
