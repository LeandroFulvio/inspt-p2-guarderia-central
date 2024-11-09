package com.guarderia.controller;

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

}
