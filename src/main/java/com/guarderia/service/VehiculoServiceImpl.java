package com.guarderia.service;

import com.guarderia.modelo.Vehiculo;
import com.guarderia.repository.VehiculoRepository;
import com.guarderia.request.VehiculoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository repository;

    @Override
    public List<Vehiculo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Vehiculo> findBySocioId(Long socioId) {
        return repository.findBySocioId(socioId);
    }

    @Override
    public void save(VehiculoRequest request) {
        var vehiculo = Vehiculo.builder()
                .matricula(request.getMatricula())
                .nombre(request.getNombre()) //TODO: Socio , tipoVehiculo
                .build();

        repository.save(vehiculo);
    }

    @Override
    public void update(String id, VehiculoRequest request) {

    }

    @Override
    public void deleteById(String id) {

    }
}
