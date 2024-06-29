package com.guarderia.service;

import com.guarderia.modelo.Socio;
import com.guarderia.request.SocioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocioServiceImpl implements SocioService{

    @Override
    public List<Socio> findAll() {
        return null;
    }

    @Override
    public Optional<Socio> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(SocioRequest request) {

    }

    @Override
    public void update(Long id, SocioRequest request) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
