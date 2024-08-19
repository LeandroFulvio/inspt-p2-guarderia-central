package com.guarderia.service;

import com.guarderia.modelo.Socio;
import com.guarderia.request.SocioRequest;

import java.util.List;
import java.util.Optional;

public interface SocioService {

    List<Socio> findAll();
    Optional<Socio> findById(Long id);
    Socio save(SocioRequest request);
    Socio update(Long id, SocioRequest request);
    void deleteById(Long id);


}
