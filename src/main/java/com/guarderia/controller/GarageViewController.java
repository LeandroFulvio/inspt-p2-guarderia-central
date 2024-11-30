package com.guarderia.controller;

import com.guarderia.modelo.Garage;
import com.guarderia.modelo.Vehiculo;
import com.guarderia.request.GarageForm;
import com.guarderia.service.GarageService;
import com.guarderia.service.SocioService;
import com.guarderia.service.VehiculoService;
import com.guarderia.service.ZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/garage")
@RequiredArgsConstructor
public class GarageViewController {

    private final GarageService service;
    private final ZonaService zonaService;
    private final SocioService socioService;
    private final VehiculoService vehiculoService;

    @GetMapping
    public String findAllGarages(Model model){
        List<Garage> garages = service.findAll();
        garages.sort(Comparator.comparing(Garage::getNumero));

        model.addAttribute("garageForm", GarageForm.builder().numero(0).build());
        model.addAttribute("socio", null);
        model.addAttribute("AllSocios", socioService.findAll());
        model.addAttribute("garages", garages );
        model.addAttribute("zonas", zonaService.findAll().stream()
                                                .filter(zona -> zona.getCantidadVehiculos() < zona.getCapacidad())
                                                .collect(Collectors.toList()) );

        return "/api/garage";
    }

    @PostMapping
    public String create(@ModelAttribute(name = "garageForm") GarageForm request){
        service.create(request);
        return "redirect:/api/garage";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteById(id);

        return "redirect:/api/garage";
    }

    @GetMapping("/asignar/{id}")
    public String showAsignarForm(@PathVariable Long id, Model model) {
        var garage = service.findById(id);
        List<Vehiculo> vehiculos = vehiculoService.findBySocioId(garage.getSocio().getId())
                .stream()
                .filter(v -> v.getFechaAsignacion() == null)
                .filter(v -> garage.getZona().getTipoVehiculoAdminitos()
                                            .contains(v.getTipoVehiculo()))
                .collect(Collectors.toList());
        model.addAttribute("garage", garage);
        model.addAttribute("vehiculos", vehiculos);

        return "api/asignargarage";
    }

    @PostMapping("/asignar/{garageId}")
    public String asignarVehiculo(@PathVariable Long garageId, @RequestParam Long vehiculoId) {
        service.asignarVehiculo(garageId, vehiculoId);
        return "redirect:/api/garage";
    }

    @PostMapping("/liberar/{id}")
    public String liberarGarage(@PathVariable Long id, Model model){
        service.vehicleEgress(id);

        model.addAttribute("garageForm", GarageForm.builder().numero(0).build());
        model.addAttribute("socio", null);
        model.addAttribute("AllSocios", socioService.findAll());
        model.addAttribute("garages", service.findAll() );
        model.addAttribute("zonas", zonaService.findAll() );

        return "redirect:/api/garage";
    }

    @GetMapping("/comprar/{id}")
    public String showComprarForm(@PathVariable Long id, Model model) {
        var socio = socioService.findById(id);
        List<Garage> garages = service.findAll()
                        .stream()
                        .filter(g -> g.getSocio() == null)
                        .collect(Collectors.toList());

        model.addAttribute("socio", socio);
        model.addAttribute("garages", garages);

        return "api/comprargarage";
    }

    @PostMapping("/comprar/{socioId}")
    public String comprarGarage(@PathVariable Long socioId, @RequestParam Long garageId) {
        service.garagePurchase(garageId, socioId);

        return "redirect:/api/socio";
    }

    @PostMapping("/vender/{id}")
    public String venderGarage(@PathVariable Long id) {
        service.removerSocio(id);

        return "redirect:/api/garage";
    }

    @GetMapping("/vehiculo/zona/{id}")
    public String verVehiculosPorZona(@PathVariable Long id, Model model){
        List<Garage> garagesZona = service.findByZonaId(id);
        List<Vehiculo> vehiculos = garagesZona.stream()
                            .map(Garage::getVehiculoGuardado)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());

        model.addAttribute("socio", null);
        model.addAttribute("tiposVehiculo", vehiculoService.findAllTipoVehiculo());
        model.addAttribute("vehiculos", vehiculos );

        return "/api/vehiculos";
    }

    @GetMapping("/socio")
    public String findGarageOfLoggedSocio(@AuthenticationPrincipal UserDetails userDetails, Model model){
        var socio = socioService.findByName(userDetails.getUsername());

        model.addAttribute("garageForm", GarageForm.builder().numero(0).build());
        model.addAttribute("socio", socio);
        model.addAttribute("AllSocios", socioService.findAll());
        model.addAttribute("garages", service.findBySocioId(socio.getId()));
        model.addAttribute("zonas", zonaService.findAll().stream()
                .filter(zona -> zona.getCantidadVehiculos() < zona.getCapacidad())
                .collect(Collectors.toList()) );

        return "/api/garage";
    }

}
