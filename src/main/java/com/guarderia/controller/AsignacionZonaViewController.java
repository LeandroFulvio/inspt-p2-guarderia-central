package com.guarderia.controller;

import com.guarderia.modelo.AsignacionZona;
import com.guarderia.request.AsignacionZonaForm;
import com.guarderia.service.AsignacionZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/asignacion")
@RequiredArgsConstructor
public class AsignacionZonaViewController {

    private final AsignacionZonaService service;

    @GetMapping
    public String findAllAsignaciones(Model model){
        model.addAttribute("AllAsignaciones", service.findAll() );

        return "/api/asignaciones";
    }

    @GetMapping("/empleado/{id}")
    public String showAsignacionForm(@PathVariable Long id, Model model) {
        model.addAttribute("empleado", service.findEmpleadoById(id));
        model.addAttribute("zonas", service.findAllZonas());
        model.addAttribute("asignacionForm",
                                AsignacionZonaForm.builder()
                                        .empleadoId(id)
                                        .build());

        return "/api/asignar";
    }

    @PostMapping("/create")
    public String createAsignacion(@ModelAttribute("asignacionForm") AsignacionZonaForm form) {
        service.create(form);
        return "redirect:/api/empleado";
    }

    @GetMapping("/delete/{id}")
    public String deleteSocio(@PathVariable Long id){
        service.deleteById(id);

        return "redirect:/api/asignacion";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("asignacion", service.findById(id));
        model.addAttribute("zonas", service.findAllZonas());

        return "/api/editAsignacion";
    }

    @PostMapping("/update")
    public String updateAsignacion(@ModelAttribute AsignacionZona asignacion) {
        service.update(asignacion);
        return "redirect:/api/asignacion";
    }

}
