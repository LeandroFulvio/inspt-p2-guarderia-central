package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.repository.GarageRepository;
import com.guarderia.request.GarageRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repository;

    @Override
    public List<Garage> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Garage> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Garage> findBySocioId(Long id) {
        return repository.findBySocioId(id);
    }

    @Override
    public Garage findByVehiculoId(Long id) {
        return repository.findByVehiculoGuardadoId(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage para el vehiculo con ID: " + id));
    }

    @Override
    public List<Garage> findByZonaId(Long id) {
        return repository.findByZonaId(id);
    }

    @Override
    public Garage save(GarageRequest request) {
        var garage = Garage.builder()
                .numero(request.getNumero())
                //TODO: add fields
                .build();

        return repository.save(garage);
    }

    @Override
    public List<Garage> saveAll(List<GarageRequest> request) {
        List<Garage> response = new ArrayList<>();
        for (GarageRequest r : request){
            response.add(save(r));
        }
        return response;
    }

    @Override
    public Garage update(Long id, GarageRequest request) {
        //TODO: update garage
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
