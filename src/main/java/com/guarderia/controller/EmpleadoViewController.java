package com.guarderia.controller;

import com.guarderia.request.EmpleadoForm;
import com.guarderia.request.SocioFrom;
import com.guarderia.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/empleado")
@RequiredArgsConstructor
public class EmpleadoViewController {

    private final EmpleadoService service;

    @GetMapping
    public String findAllSocios(Model model){
        model.addAttribute("empleados", service.findAll() );

        return "/api/empleado";
    }

    @PostMapping
    public String create(@ModelAttribute(name = "EmpleadoForm") EmpleadoForm request){
        service.save(request);
        return "redirect:/api/empleado";
    }
}
