/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.web;
import com.ciclo3.model.Gama;
import com.ciclo3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Gama/")
public class GamaWeb {
    /**
     * Inicializamos Api Gama
     */
    @Autowired
    private GamaService gamaApi;

    /**
     * Método para obtener todas las gamas por URL
     *
     * @return
     */
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Gama> getAll() {
        return gamaApi.getAll();
    }

    /**
     * Método para obtener una Gama por su id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Gama> getGama(@PathVariable("id") int id) {
        return gamaApi.getGama(id);
    }

    /**
     * Método para agregar una gama por URL
     *
     * @param gama
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama) {
        return gamaApi.save(gama);
    }
/**
     * Método para actualizar una gama
     * @param gama
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama) {
        return gamaApi.update(gama);
    }

    /**
     * Método para eliminar una gama
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return gamaApi.delete(id);
    }
}

