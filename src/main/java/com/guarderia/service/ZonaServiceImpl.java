package com.guarderia.service;

import com.guarderia.modelo.Zona;
import com.guarderia.repository.ZonaRepository;
import com.guarderia.request.ZonaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository repository;

    @Override
    public List<Zona> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Zona> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(ZonaRequest request) {

    }

    @Override
    public void update(String id, ZonaRequest request) {

    }

    @Override
    public void deleteById(String id) {

    }
}
