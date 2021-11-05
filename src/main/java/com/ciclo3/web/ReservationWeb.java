/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.web;
import com.ciclo3.model.Reservation;
import com.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author MIGUEL
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation/")
public class ReservationWeb {
    /**
     * Inicializamos API Reservation
     */
    @Autowired
    private ReservationService reservationApi;

    /**
     * Método para obtener todas las reservaciones por URL
     *
     * @return
     */
    @GetMapping("all")
    public List<Reservation> getAll() {
        return reservationApi.getAll();
    }

    /**
     * Método para obtener todas las reservaciones en una fecha específica
     *
     * @return
     */
    @GetMapping("report-dates/{from}/{to}")
    public List<Reservation> getByDate(@PathVariable("from") String sFrom, @PathVariable("to") String sTo){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        try {
            from = formato.parse(sFrom);
            to = formato.parse(sTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reservationApi.getByDate(from, to);
    }

    /**
     * Método para obtener el conteo las reservas completas de cada cliente
     * @return
     */
    @GetMapping("report-clients")
    public List<Object> getClientReport(){
        return reservationApi.getClientReport();
    }

    /**
     * Método para obtener el mapeo para retornar el conteo de reservas completas vs canceladas
     * @return
     */
    @GetMapping("report-status")
    public LinkedHashMap<String, Integer> getVs(){
        return reservationApi.getVs();
    }
    /**
     * Método para obtener una reservación por id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationApi.getReservation(id);
    }

    /**
     * Método para agregar una reservación por URL
     *
     * @param reservation
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationApi.save(reservation);
    }

    /**
     * Método para actualizar una reservación
     * @param reservation
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationApi.update(reservation);
    }

    /**
     * Método para elimiar una reservación
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservationApi.delete(id);
    }
}
