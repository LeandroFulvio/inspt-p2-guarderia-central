package com.guarderia.repository;

import com.guarderia.modelo.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GarageRepository extends JpaRepository<Garage,Long> {

    List<Garage> findBySocioId(Long id);
    List<Garage> findByZonaId(Long id);
    Optional<Garage> findByVehiculoGuardadoId(Long id);

}
