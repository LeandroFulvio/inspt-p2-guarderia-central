package com.guarderia.controller;

import com.guarderia.modelo.Socio;
import com.guarderia.request.SocioFrom;
import com.guarderia.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/socio")
@RequiredArgsConstructor
public class SocioViewController {

    private final SocioService service;

    @GetMapping
    public String findAllSocios(Model model){
        model.addAttribute("socios", service.findAll() );

        return "/api/socio";
    }

    @PostMapping
    public String create(@ModelAttribute(name = "SocioForm") SocioFrom request){
        service.save(request);
        return "redirect:/api/socio";
    }

    @GetMapping("/edit/{id}")
    public String showSocio(@PathVariable Long id, Model model){
        model.addAttribute("socio", service.findById(id) );

        return "/api/showSocio";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Socio socio, Model model){
        service.update(socio);
        model.addAttribute("socios", service.findAll() );

        return "/api/socio";
    }

    @GetMapping("/delete/{id}")
    public String deleteSocio(@PathVariable Long id){
        service.deleteById(id);

        return "redirect:/api/socio";
    }

}
