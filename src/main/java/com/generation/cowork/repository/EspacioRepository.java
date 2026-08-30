package com.generation.cowork.repository;

import com.generation.cowork.model.Espacio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EspacioRepository {

    //Lista interna
    private final List<Espacio> espacios = new ArrayList<>();

    //Variable Contador
    private Long numeroId = 1L;



    //Metodos

        //Devolver todos los espacios
    public List<Espacio> encontrarTodo(){
        return espacios;
    }

        //Delvolver espacio por id
    public Optional<Espacio> encontrarId(Long id){
        return espacios.stream().filter(espacio -> espacio.getId().equals(id)).findFirst();
    }

        //Devolver por categoria
    public List<Espacio> encontrarCategoria(String categoria){
        if (categoria == null){
            return List.of();
        }
        return espacios.stream()
                .filter(espacio -> espacio.getNombreCategoria()
                        .equalsIgnoreCase(categoria.toUpperCase()))
                .toList();
    }

        //Guardar espacio nuevo asignando id
    public Espacio guardar(Espacio espacio){
        espacio.setId(numeroId);
        numeroId ++;
        espacios.add(espacio);
        return espacio;
    }

        //Actualizar espacio existente
    public Optional<Espacio> actualizar(Long id, Espacio nuevosDatos){
        return  espacios.stream().filter(espacio -> espacio.getId().equals(id))
                .findFirst()
                .map(espacio -> {
                    espacio.setNombre(nuevosDatos.getNombre());
                    espacio.setCapacidad(nuevosDatos.getCapacidad());
                    espacio.setDescripcion(nuevosDatos.getDescripcion());
                    espacio.setNombreSede(nuevosDatos.getNombreSede());
                    espacio.setNombreCategoria(nuevosDatos.getNombreCategoria());
                    espacio.setPrecioHora(nuevosDatos.getPrecioHora());
                    return espacio;
                });
    }

        //Eliminar por id
    public boolean eliminar(Long id){
        return espacios.removeIf(espacio -> espacio.getId().equals(id));
    }
}
