/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository;

import com.ciclo3.model.Car;
import com.ciclo3.repository.crud.CarCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Repository
public class CarRepository {
    /**
     * Atributo Repositorio Car
     */
    @Autowired
    private CarCrud carCrud;

    /**
     * Método para encontrar todos los carros del repositorio
     *
     * @return
     */
    public List<Car> getAll() {
        return (List<Car>) carCrud.findAll();
    }

    /**
     * Método para encontrar un carro por id
     *
     * @param id
     * @return
     */
    public Optional<Car> getCar(int id) {
        return carCrud.findById(id);
    }

    /**
     * Método para agregar un carro nuevo
     *
     * @param carros
     * @return
     */
    public Car save(Car carros) {
        return carCrud.save(carros);
    }

    /**
     * Método para eliminar un carro
     *
     * @param carros
     */
    public void delete(Car carros) {
        carCrud.delete(carros);
    }
}

