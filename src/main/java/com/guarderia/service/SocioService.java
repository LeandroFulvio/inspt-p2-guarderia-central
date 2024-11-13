package com.guarderia.service;

import com.guarderia.modelo.Socio;
import com.guarderia.request.SocioFrom;
import com.guarderia.request.SocioRequest;

import java.util.List;
import java.util.Optional;

public interface SocioService {

    List<Socio> findAll();
    Socio findById(Long id);
    Socio save(SocioRequest request);
    Socio save(SocioFrom request);
    Socio update(Long id, SocioRequest request);
    Socio update(Socio socio);
    void deleteById(Long id);


}
