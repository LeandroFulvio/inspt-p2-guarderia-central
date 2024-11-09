package com.guarderia.controler;

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
        return "dashboard";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        // Vacio aproposito, para prevenir error al buscar el recurso
        // Devuelve vacio pero 200 OK status
    }

}
