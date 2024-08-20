package com.guarderia.repository;

import com.guarderia.modelo.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoVehiculoRepository  extends JpaRepository<TipoVehiculo, Long> {

    Optional<TipoVehiculo> findByNombre(String nombre);

}
