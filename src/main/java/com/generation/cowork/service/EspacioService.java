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
        return espacioRepository.save(espacio);
    }

        //Read all
    public List<Espacio> ListarEspacios(){
        return espacioRepository.findAll();
    }

        //Read one
    public Optional<Espacio> ListarID(Long id){
        return espacioRepository.findById(id);
    }

        //Update
    public Optional<Espacio> actualizar(Long id, Espacio datosEspacio){
        return espacioRepository.findById(id)
                .map(espacio -> {
                    espacio.setNombre(datosEspacio.getNombre());
                    espacio.setCapacidad(datosEspacio.getCapacidad());
                    espacio.setDescripcion(datosEspacio.getDescripcion());
                    espacio.setNombreSede(datosEspacio.getNombreSede());
                    espacio.setNombreCategoria(datosEspacio.getNombreCategoria());
                    espacio.setPrecioHora(datosEspacio.getPrecioHora());
                    return espacioRepository.save(espacio);
                });
    }


        //Delete
    public Boolean eliminarId(Long id){
        if (! espacioRepository.existsById(id)){
            return false;
        }
        espacioRepository.deleteById(id);
        return true;
    }


    /*
    //Read Category
    public List<Espacio> listarCategoria(String categoria){
        if(categoria == null){
            return List.of();
        }

        List<Espacio>
        espacioRepository.findBy()


    }


    public List<Espacio> listarCategoria(String categoria){

        if (categoria == null){
            return List.of();
        }
        return espacios.stream()
                .filter(espacio -> espacio.getNombreCategoria()
                        .equalsIgnoreCase(categoria.toUpperCase()))
                .toList();
    }*/

}

