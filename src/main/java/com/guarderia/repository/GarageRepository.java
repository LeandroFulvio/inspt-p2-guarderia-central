package com.guarderia.repository;

import com.guarderia.modelo.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage,Long> {

    List<Garage> findBySocioId(Long id);


}
