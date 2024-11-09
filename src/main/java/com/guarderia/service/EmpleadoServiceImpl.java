package com.guarderia.service;

import com.guarderia.modelo.Empleado;
import com.guarderia.repository.EmpleadoRepository;
import com.guarderia.request.EmpleadoForm;
import com.guarderia.request.EmpleadoRequest;
import com.guarderia.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository repository;
    private final UserService userService;

    @Override
    public List<Empleado> findAll() {
        return repository.findAll();
    }

    @Override
    public Empleado findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro empleado con ID: " + id));
    }

    @Override
    public Empleado save(EmpleadoRequest request) {
        var empleado = Empleado.builder()
                .dni(request.getDni())
                .direccion(request.getDireccion())
                .codigo(request.getCodigo())
                .telefono(request.getTelefono())
                .especialidad(request.getEspecialidad())
                .user(userService.getUserById(request.getUserId()))
                .build();

        return repository.save(empleado);
    }

    @Override
    public Empleado save(EmpleadoForm request) {
        var user = userService.create(request);

        var empleado = Empleado.builder()
                .dni(request.getDni())
                .direccion(request.getDireccion())
                .codigo(request.getCodigo())
                .telefono(request.getTelefono())
                .especialidad(request.getEspecialidad())
                .user(user)
                .build();

        return repository.save(empleado);
    }

    @Override
    public Empleado update(Long id, EmpleadoRequest request) {
        var empleado = findById(id);
        empleado.setCodigo(request.getCodigo());
        empleado.setDni(request.getDni());
        empleado.setTelefono(request.getTelefono());
        empleado.setEspecialidad(request.getEspecialidad());
        empleado.setDireccion(request.getDireccion());
        repository.save(empleado);

        return empleado;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
