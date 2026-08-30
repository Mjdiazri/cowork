package com.generation.cowork.service;

import com.generation.cowork.model.Espacio;
import com.generation.cowork.repository.EspacioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioService {

    //Variables
    private EspacioRepository espacioRepository;

    //Constructor
    public EspacioService(EspacioRepository repository) {
        this.espacioRepository = repository;
    }

    //Metodos Crud

        //Create
    public Espacio guardarNuevoEspacio(Espacio espacio){
        return espacioRepository.guardar(espacio);
    }

        //Read all
    public List<Espacio> ListarEspacios(){
        return espacioRepository.encontrarTodo();
    }

        //Read one
    public Optional<Espacio> ListarID(Long id){
        return espacioRepository.encontrarId(id);
    }

        //Read Category
    public List<Espacio> listarCategoria(String categoria){
        return espacioRepository.encontrarCategoria(categoria);
    }

        //Update
    public Optional<Espacio> actualizar(Long id, Espacio datosEspacio){
        return espacioRepository.actualizar(id,datosEspacio);
    }

        //Delete
    public Boolean eliminarId(Long id){
        return espacioRepository.eliminar(id);
    }

}

