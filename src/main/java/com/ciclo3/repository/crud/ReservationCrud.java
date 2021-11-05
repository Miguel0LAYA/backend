/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository.crud;
import com.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author MIGUEL
 */
public interface ReservationCrud extends CrudRepository<Reservation, Integer> {
}