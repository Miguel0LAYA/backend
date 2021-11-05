/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository;

import com.ciclo3.model.Gama;
import com.ciclo3.repository.crud.GamaCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Repository
public class GamaRepository {
    /**
     * Atributo Repositorio Gama
     */
    @Autowired
    private GamaCrud gamaCrud;

    /**
     * Método para obtener todas las gamas del repositorio
     *
     * @return
     */
    public List<Gama> getAll() {
        return (List<Gama>) gamaCrud.findAll();
    }

    /**
     * Método para buscar una gama por id
     *
     * @param id
     * @return
     */
    public Optional<Gama> getGama(int id) {
        return gamaCrud.findById(id);
    }

    /**
     * Método para agregar una gama
     *
     * @param gama
     * @return
     */
    public Gama save(Gama gama) {
        return gamaCrud.save(gama);
    }

    /**
     * Método para eliminar una Gama
     *
     * @param gama
     */
    public void delete(Gama gama) {
        gamaCrud.delete(gama);
    }
}

