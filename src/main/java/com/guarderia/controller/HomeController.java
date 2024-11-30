package com.guarderia.controller;

import com.guarderia.modelo.AsignacionZona;
import com.guarderia.modelo.Garage;
import com.guarderia.modelo.Vehiculo;
import com.guarderia.modelo.Zona;
import com.guarderia.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final EmpleadoService empleadoService;
    private final SocioService socioService;
    private final GarageService garageService;
    private final VehiculoService vehiculoService;
    private final ZonaService zonaService;
    private final AsignacionZonaService asignacionZonaService;

    @GetMapping()
    public String index() {
        return "login";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("dashboard")
    public String dashboard() {
        //cantidad de garages
        //cantidad de garages ocupados
        //lista de zonas con su capacidad y cantidad de vehiculos guardados

        //cantidad de socios
        //cantidad de vehiculos

        return "dashboard";
    }

    @GetMapping("socio-dashboard")
    public String socioDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var socio = socioService.findByName(userDetails.getUsername());

        List<Garage> misGarages = garageService.findBySocioId(socio.getId());
        List<Vehiculo> misVehiculos = vehiculoService.findBySocioId(socio.getId());

        model.addAttribute("socio", socio);
        model.addAttribute("misGarages", misGarages);
        model.addAttribute("misVehiculos", misVehiculos);

        return "socio-dashboard";
    }

    @GetMapping("empleado-dashboard")
    public String empleadoDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        var empleado = empleadoService.findByName(userDetails.getUsername());

        List<AsignacionZona> asignaciones = asignacionZonaService.findByEmpleadoId(empleado.getId());

        model.addAttribute("empleado", empleado);
        model.addAttribute("asignaciones", asignaciones);

        return "empleado-dashboard";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        // Vacio aproposito, para prevenir error al buscar el recurso
        // Devuelve vacio pero 200 OK status
    }

}
