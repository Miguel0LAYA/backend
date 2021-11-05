/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.web;
import com.ciclo3.model.Car;
import com.ciclo3.service.CarService;
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
@RequestMapping("/api/Car/")
public class CarWeb {
    /**
     * Inicializamos el Api Car
     */
    @Autowired
    private CarService carApi;

    /**
     * Método para obtener los carros por URL
     *
     * @return
     */
    @GetMapping("all")
    public List<Car> getCar() {
        return carApi.getAll();
    }

    /**
     * Método para obtener un carro por id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Car> getCar(@PathVariable("id") int id) {
        return carApi.getCar(id);
    }

    /**
     * Método para agregar un carro desde URL
     *
     * @param carros
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car carros) {
        return carApi.save(carros);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car carros) {
        return carApi.update(carros);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return carApi.delete(id);
    }
}
