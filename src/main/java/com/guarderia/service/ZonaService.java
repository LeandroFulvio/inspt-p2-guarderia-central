package com.guarderia.service;

import com.guarderia.modelo.Zona;
import com.guarderia.request.ZonaRequest;

import java.util.List;
import java.util.Optional;

public interface ZonaService {

    List<Zona> findAll();
    Zona findById(Long id);
    Zona save(ZonaRequest request);
    Zona update(Long id, ZonaRequest request);
    void deleteById(Long id);

}
