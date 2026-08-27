package com.generation.cowork.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetController {

    @GetMapping("/greet")
    public String greet(){
        return "Bienvenido a CoWork API, Tu espacio de coworking";
    }

    @GetMapping("/saludo")
    public String saludo(){
        return "CoWork Pinguin APP esta iniciando. Bienvenido a la gestion de espacios";
    }
}
