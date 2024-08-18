package com.guarderia.service;

import com.guarderia.modelo.Socio;
import com.guarderia.repository.SocioRepository;
import com.guarderia.request.SocioRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocioServiceImpl implements SocioService{

    private final SocioRepository repository;

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
        var socio = Socio.builder()
                .id(request.getId())
                .build();

        repository.save(socio);

    }

    @Override
    public void update(Long id, SocioRequest request) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
