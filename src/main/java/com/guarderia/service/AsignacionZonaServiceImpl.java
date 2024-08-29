package com.guarderia.service;

import com.guarderia.modelo.AsignacionZona;
import com.guarderia.repository.AsignacionZonaRepository;
import com.guarderia.request.AsignacionZonaRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionZonaServiceImpl implements AsignacionZonaService{

    private final AsignacionZonaRepository repository;
    private final EmpleadoService empleadoService;
    private final ZonaService zonaService;

    @Override
    public List<AsignacionZona> findAll() {
        return repository.findAll();
    }

    @Override
    public AsignacionZona findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro asignacion con ID: " + id));
    }

    @Override
    public List<AsignacionZona> findByEmpleadoId(Long id) {
        return repository.findByEmpleadoId(id);
    }

    @Override
    public List<AsignacionZona> findByZonaId(Long id) {
        return repository.findByZonaId(id);
    }

    @Override
    public AsignacionZona save(AsignacionZonaRequest request) {
        var asignacion = AsignacionZona.builder()
                .id(request.getId())
                .zona(zonaService.findById(request.getZonaId()))
                .empleado(empleadoService.findById(request.getEmpleadoId()))
                .vehiculosACargo(request.getVehiculosAsignados())
                .build();

        return repository.save(asignacion);
    }

    @Override
    public List<AsignacionZona> saveAll(List<AsignacionZonaRequest> request) {
        List<AsignacionZona> response = new ArrayList<>();
        for (AsignacionZonaRequest r : request){
            response.add(save(r));
        }
        return response;
    }

    @Override
    public AsignacionZona update(Long id, AsignacionZonaRequest request) {
        var asignacion = findById(id);
        asignacion.setZona(zonaService.findById(request.getZonaId()));
        asignacion.setEmpleado(empleadoService.findById(request.getEmpleadoId()));
        asignacion.setVehiculosACargo(request.getVehiculosAsignados());

        repository.save(asignacion);

        return asignacion;
    }

    @Override
    public List<AsignacionZona> updateAll(List<AsignacionZonaRequest> request) {
        List<AsignacionZona> response = new ArrayList<>();
        for (AsignacionZonaRequest r : request){
            response.add(this.update(r.getId(), r));
        }
        return response;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
