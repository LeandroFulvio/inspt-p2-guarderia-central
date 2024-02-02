package com.guarderia.service;

import com.guarderia.modelo.Zona;
import com.guarderia.request.ZonaRequest;

import java.util.List;
import java.util.Optional;

public interface ZonaService {

    List<Zona> findAll();
    Optional<Zona> findById(String id);
    void save(ZonaRequest request);
    void update(String id, ZonaRequest request);
    void deleteById(String id);


}
