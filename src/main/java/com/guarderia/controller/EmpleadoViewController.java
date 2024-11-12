package com.guarderia.controller;

import com.guarderia.modelo.Empleado;
import com.guarderia.request.EmpleadoForm;
import com.guarderia.request.SocioFrom;
import com.guarderia.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/empleado")
@RequiredArgsConstructor
public class EmpleadoViewController {

    private final EmpleadoService service;

    @GetMapping
    public String findAllEmpleados(Model model){
        model.addAttribute("empleados", service.findAll() );

        return "/api/empleado";
    }

    @GetMapping("/edit/{id}")
    public String showEmpleado(@PathVariable Long id, Model model){
        model.addAttribute("empleado", service.findById(id) );

        return "/api/showEmpleado";
    }

    @PostMapping
    public String create(@ModelAttribute(name = "empleadoForm") EmpleadoForm request){
        service.save(request);
        return "redirect:/api/empleado";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmpleado(@PathVariable Long id){
        service.deleteById(id);

        return "redirect:/api/empleado";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Empleado empleado, Model model){
        service.update(empleado);
        model.addAttribute("empleados", service.findAll() );

        return "/api/empleado";
    }

}
