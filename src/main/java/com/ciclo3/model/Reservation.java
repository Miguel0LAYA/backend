/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    /**
     * Atributo id de la reservación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idReservation;
    /**
     * Atributo Fecha inicial de la reservación
     */
    @Column(name = "startDate")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /**
     * Atributo Fecha de devolución
     */
    @Column(name = "devolutionDate")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date devolutionDate;
    /**
     * Atributo estado de la reservación
     */
    @Column(name = "status")
    private String status = "created";

    /**
     * Relación muchos a uno tabla car
     */
    @ManyToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties("reservations")
    private Car car;
/**
     * Relación muchos a uno tabla client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    /**
     * Atributo score
     */
    @Column(name = "score")
    private Integer score;

    // Getter y Setter
    
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

