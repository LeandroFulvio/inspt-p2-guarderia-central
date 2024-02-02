package com.guarderia.repository;

import com.guarderia.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findBySocioId (int socioId);

}
