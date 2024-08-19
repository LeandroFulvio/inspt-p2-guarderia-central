package com.guarderia.service;

import com.guarderia.modelo.Socio;
import com.guarderia.repository.SocioRepository;
import com.guarderia.request.SocioRequest;
import com.guarderia.user.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocioServiceImpl implements SocioService{

    private final SocioRepository repository;
    private final UserService userService;

    @Override
    public List<Socio> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Socio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Socio save(SocioRequest request) {
        var socio = Socio.builder()
                .id(request.getId())
                .dni(request.getDni())
                .direccion(request.getDireccion())
                .telefono(request.getTelefono())
                .user(userService.getUserById(request.getUserId()))
                .fechaIngreso(new Date())
                .build();

        return repository.save(socio);
    }

    @Override
    public Socio update(Long id, SocioRequest request) {
        var socio = repository.findById(id).orElseThrow();
        socio.setDni(request.getDni());
        socio.setDireccion(request.getDireccion());
        socio.setTelefono(request.getTelefono());
//        socio.setVehiculoList(request.getVehiculos());
        //TODO: manejo de Vehiculos

        return repository.save(socio);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
