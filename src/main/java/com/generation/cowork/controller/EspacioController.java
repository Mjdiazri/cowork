package com.generation.cowork.controller;

import com.generation.cowork.model.Espacio;
import com.generation.cowork.service.EspacioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<Espacio> listarID(@PathVariable Long id){
        return espacioService.ListarID(id).map(espacio -> ResponseEntity.ok(espacio))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

        //Crear
    @PostMapping
    public ResponseEntity<Espacio> crearEspacio(@RequestBody Espacio espacio){
        Espacio nuevoEspacio = espacioService.guardarNuevoEspacio(espacio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEspacio);
    }

        //Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Espacio> actualizarEspacio(@PathVariable Long id,@RequestBody Espacio espacio){
    return espacioService.actualizar(id, espacio).map(espacio1 -> ResponseEntity.ok(espacio1))
            .orElseGet(()-> ResponseEntity.notFound().build());
    }

        //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspacio(@PathVariable Long id){
        if(espacioService.eliminarId(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }



}
