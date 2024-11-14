package com.guarderia.controller;

import com.guarderia.modelo.Zona;
import com.guarderia.request.ZonaForm;
import com.guarderia.service.TipoVehiculoService;
import com.guarderia.service.ZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/zona")
@RequiredArgsConstructor
public class ZonaViewController {

    private final ZonaService service;
    private final TipoVehiculoService tipoVehiculoService;

    @GetMapping
    public String findAllZonas(Model model){
        model.addAttribute("zonas", service.findAll() );
        model.addAttribute("tipoVehiculos", tipoVehiculoService.findAll());

        return "/api/zona";
    }

    @GetMapping("/{id}")
    public String findZonaById(@PathVariable Long id, Model model){
        model.addAttribute("zona", service.findById(id) );

        return "/api/zona"; //TODO: a donde con 1 zona?
    }

    @PostMapping
    public String create(@ModelAttribute(name = "zonaForm") ZonaForm form){
        service.save(form);
        return "redirect:/api/zona";
    }

    @GetMapping("/edit/{id}")
    public String showZona(@PathVariable Long id, Model model){
        model.addAttribute("zona", service.findById(id) );
        model.addAttribute("allTipoVehiculos", tipoVehiculoService.findAll());

        return "/api/showZona";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Zona zona, Model model){
        service.update(zona);
        model.addAttribute("zonas", service.findAll() );

        return "redirect:/api/zona";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteById(id);

        return "redirect:/api/zona";
    }

}
