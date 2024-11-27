package com.guarderia.repository;

import com.guarderia.modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    Socio findByUserUsername(String username);

}
