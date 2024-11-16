package com.guarderia.controller;

import com.guarderia.request.VehiculoForm;
import com.guarderia.service.SocioService;
import com.guarderia.service.TipoVehiculoService;
import com.guarderia.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoViewController {

    private final VehiculoService service;
    private final SocioService socioService;
    private final TipoVehiculoService tipoVehiculoService;

    @GetMapping
    public String findAllVehiculos(Model model){
        model.addAttribute("socio", null);
        model.addAttribute("vehiculos", service.findAll() );
        model.addAttribute("tipoVehiculos", tipoVehiculoService.findAll());

        return "/api/vehiculos";
    }

    //Get by Id ?

    @GetMapping("/socio/{id}")
    public String showCreationForm(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.findById(id));
        model.addAttribute("tiposVehiculo", tipoVehiculoService.findAll());
        model.addAttribute("vehiculoForm", VehiculoForm.builder().idSocio(id).build() );

        return "/api/registrarVehiculo";
    }

    @GetMapping("/vehiculosocio/{id}")
    public String showVehiclesFrom(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.findById(id));
        model.addAttribute("tiposVehiculo", tipoVehiculoService.findAll());
        model.addAttribute("vehiculos", service.findBySocioId(id) );

        return "/api/vehiculos";
    }

    @PostMapping("/create")
    public String createVehiculo(@ModelAttribute("vehiculoForm") VehiculoForm form) {
        service.create(form);
        return "redirect:/api/socio";
    }

}
