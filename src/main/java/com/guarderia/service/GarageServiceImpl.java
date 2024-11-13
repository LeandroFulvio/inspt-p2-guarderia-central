package com.guarderia.service;

import com.guarderia.modelo.Garage;
import com.guarderia.repository.GarageRepository;
import com.guarderia.request.GarageRequest;
import com.guarderia.request.VehiculoRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {

    private final GarageRepository repository;
    private final ZonaService zonaService;
    private final SocioService  socioService;
    private final VehiculoService vehiculoService;

    @Override
    public List<Garage> findAll() {
        return repository.findAll();
    }

    @Override
    public Garage findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage con ID: " + id));
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
    public Garage create(GarageRequest request) {
        var socio = socioService.findById(request.getSocioId());

        var garage = Garage.builder()
                .numero(request.getNumero())
                .mantenimientoContratado(request.isMantenimientoContratado())
                .contadorLuz(request.getContadorLuz())
                .zona(zonaService.findById(request.getZonaId()))
                .socio(socio)
                .fechaCompra(socio!=null ? new Date() : null)
                .build();
        return repository.save(garage);
    }

    @Override
    public Garage save(GarageRequest request) {
        var garage = Garage.builder()
                .numero(request.getNumero())
                .mantenimientoContratado(request.isMantenimientoContratado())
                .contadorLuz(request.getContadorLuz())
                .zona(zonaService.findById(request.getZonaId()))
                .vehiculoGuardado(vehiculoService.findById(request.getVehiculoGuardadoId()))
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
        var garage = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage con ID: " + id));
        garage.setSocio(socioService.findById(request.getSocioId()));
        garage.setVehiculoGuardado(vehiculoService.findById(request.getVehiculoGuardadoId()));
        garage.setZona(zonaService.findById(request.getZonaId()));
        garage.setContadorLuz(request.getContadorLuz());
        garage.setMantenimientoContratado(request.isMantenimientoContratado());
        garage.setNumero(request.getNumero());
        garage.setFechaCompra(request.getFechaCompra());//Maybe not?

        return repository.save(garage);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Garage garagePurchase(Long id, Long socioId) {
        var garage = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage con ID: " + id));
        var socio = socioService.findById(socioId);

        garage.setSocio(socio);
        garage.setFechaCompra(new Date());

        return repository.save(garage);
    }

    @Override
    public Garage vehicleIngress(Long id, VehiculoRequest vehiculoRequest) {
        var garage = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage con ID: " + id));

        var vehiculo = vehiculoService.findOrCreate(vehiculoRequest);
        vehiculo.setFechaAsignacion(new Date());
        garage.setVehiculoGuardado(vehiculo);
        garage.getZona().setCantidadVehiculos(garage.getZona().getCantidadVehiculos()+1);

        return repository.save(garage);
    }

    @Override
    public Garage vehicleEgress(Long id) {
        var garage = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro garage con ID: " + id));

        vehiculoService.removerAsignacion(garage.getVehiculoGuardado().getId());
        garage.setVehiculoGuardado(null);
        garage.getZona().setCantidadVehiculos(garage.getZona().getCantidadVehiculos()-1);

        return repository.save(garage);
    }

    //getVehicleByZona ?

}
