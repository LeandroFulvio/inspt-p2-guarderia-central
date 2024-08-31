package com.guarderia.service;

import com.guarderia.modelo.Vehiculo;
import com.guarderia.repository.VehiculoRepository;
import com.guarderia.request.VehiculoRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository repository;

    private final SocioService socioService;
    private final TipoVehiculoService tipoVehiculoService;

    @Override
    public List<Vehiculo> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehiculo findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro vehiculo con ID: " + id));
    }

    @Override
    public List<Vehiculo> findBySocioId(Long socioId) {
        return repository.findBySocioId(socioId);
    }

    @Override
    public Vehiculo save(VehiculoRequest request) {
        var vehiculo = Vehiculo.builder()
                .matricula(request.getMatricula())
                .nombre(request.getNombre())
                .socio(socioService.findById(request.getIdSocio())
                        .orElseThrow(() -> new EntityNotFoundException("No se encontro socio con ID: " + request.getId())))
                .tipoVehiculo(tipoVehiculoService.findById(request.getTipoVehiculo())
                        .orElseThrow(() -> new EntityNotFoundException("No se encontro el tipo de vehiculo con ID: " + request.getTipoVehiculo())))
                .build();

        return repository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> saveAll(List<VehiculoRequest> request) {
        List<Vehiculo> response = new ArrayList<>();
        for (VehiculoRequest r : request) {
            response.add(save(r));
        }
        return response;
    }

    @Override
    public Vehiculo update(Long id, VehiculoRequest request) {
        var vehiculo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro vehiculo con ID: " + id));
        vehiculo.setNombre(request.getNombre());
        vehiculo.setTipoVehiculo(tipoVehiculoService.findById(request.getTipoVehiculo())
                        .orElseThrow(() ->
                                new EntityNotFoundException("No se encontro " +
                                "el tipo de vehiculo con ID: " + request.getTipoVehiculo())));
        vehiculo.setSocio(socioService.findById(request.getIdSocio())
                        .orElseThrow(() ->
                                new EntityNotFoundException("No se encontro socio con ID: " + request.getId())));
        vehiculo.setFechaAsignacion(request.getFechaAsignacion());

        return repository.save(vehiculo);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Vehiculo findOrCreate(VehiculoRequest request) {
        if(request.getId()!=null) {
            var v = repository.findById(request.getId())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro vehiculo con ID: " + request.getId()));
            v.setFechaAsignacion(new Date());
            return v;
        }

        return save(request);
    }

    @Override
    public Vehiculo removerAsignacion(Long id) {
        var v = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro vehiculo con ID: " + id));
        v.setFechaAsignacion(null);
        return repository.save(v);
    }


}
