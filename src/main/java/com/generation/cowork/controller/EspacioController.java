package com.generation.cowork.controller;

import com.generation.cowork.model.Espacio;
import com.generation.cowork.service.EspacioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    //Variables
    private EspacioService espacioService;

    //Constructor
    public EspacioController(EspacioService service){
        this.espacioService = service;
    }

    //EndPoints

        //Get
    @GetMapping
    public ResponseEntity<List<Espacio>> listar(){
        return ResponseEntity.ok(espacioService.ListarEspacios());
    }

        //Get ID


}
