package com.guarderia.repository;

import com.guarderia.modelo.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage,Long> {

    List<Garage> findBySocioId(int id);

}
