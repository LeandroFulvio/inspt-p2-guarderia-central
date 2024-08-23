package com.guarderia.repository;

import com.guarderia.modelo.AsignacionZona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionZonaRepository extends JpaRepository<AsignacionZona, Long> {

    List<AsignacionZona> findByEmpleadoId(Long id);
    List<AsignacionZona> findByZonaId(Long id);

}
