/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository;
import com.ciclo3.model.Reservation;
import com.ciclo3.repository.crud.ReservationCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Repository
public class ReservationRepository {
    /**
     * Atributo Repositorio Reervation
     */
    @Autowired
    private ReservationCrud reservationCrud;

    /**
     * Método para obtener todas las reservaciones
     *
     * @return
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrud.findAll();
    }

    /**
     * Método para buscar una reservación por id
     *
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id) {
        return reservationCrud.findById(id);
    }

    /**
     * Método para agregar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        return reservationCrud.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrud.delete(reservation);
    }
}

