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
    private final TipoVehiculoService tipoVehiculoService;

    @Override
    public List<Zona> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Zona> findById(Long id) {
        return repository.findById(id);
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
        //TODO: Zona update
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
