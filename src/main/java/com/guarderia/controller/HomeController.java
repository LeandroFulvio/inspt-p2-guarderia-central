package com.guarderia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

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
    public String socioDashboard() {
        //mis datos? cantidad de vehiculos, cantidad de garages, garages libres, vehiculos sin guardar

        return "dashboard";
    }

    @GetMapping("empleado-dashboard")
    public String empleadoDashboard() {
        //cantidad de zonas asignadas
        //cantidad de autos en zonas asignadas?
        return "dashboard";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        // Vacio aproposito, para prevenir error al buscar el recurso
        // Devuelve vacio pero 200 OK status
    }

}
