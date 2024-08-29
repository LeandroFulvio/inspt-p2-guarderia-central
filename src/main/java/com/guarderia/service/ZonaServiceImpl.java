package com.guarderia.service;

import com.guarderia.modelo.Zona;
import com.guarderia.repository.ZonaRepository;
import com.guarderia.request.ZonaRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository repository;
    private final TipoVehiculoService tipoVehiculoService;

    @Override
    public List<Zona> findAll() {
        return repository.findAll();
    }

    @Override
    public Zona findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro zona con ID: " + id));
    }

    @Override
    public Zona save(ZonaRequest request) {
        var zona = Zona.builder()
                .letra(request.getLetra())
                .capacidad(request.getCapacidad())
                .cantidadVehiculos(0)
                .tipoVehiculoAdminitos(tipoVehiculoService.findAll(request.getTipoVehiculoAdmitidos())) //TODO: tipovehiculo
                .build();

        return repository.save(zona);
    }

    @Override
    public Zona update(Long id, ZonaRequest request) {
        var zona = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro zona con ID: " + id));
        zona.setLetra(request.getLetra());
        zona.setCapacidad(request.getCapacidad());
        zona.setTipoVehiculoAdminitos(tipoVehiculoService.findAll(request.getTipoVehiculoAdmitidos()));
        zona.setCantidadVehiculos(request.getCantidadVehiculos());

        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
