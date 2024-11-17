package com.guarderia.controller;

import com.guarderia.request.GarageForm;
import com.guarderia.service.GarageService;
import com.guarderia.service.SocioService;
import com.guarderia.service.ZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/garage")
@RequiredArgsConstructor
public class GarageViewController {

    private final GarageService service;
    private final ZonaService zonaService;
    private final SocioService socioService;

    @GetMapping
    public String findAllEmpleados(Model model){
        model.addAttribute("garageForm", GarageForm.builder().numero(0).build());
        model.addAttribute("socio", null);
        model.addAttribute("AllSocios", socioService.findAll());
        model.addAttribute("garages", service.findAll() );
        model.addAttribute("zonas", zonaService.findAll() );

        return "/api/garage";
    }

    @PostMapping
    public String create(@ModelAttribute(name = "garageForm") GarageForm request){
        service.create(request);
        return "redirect:/api/garage";
    }

}
