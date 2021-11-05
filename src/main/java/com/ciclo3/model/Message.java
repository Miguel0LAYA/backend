/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    /**
     * Atributo idMessage
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idMessage;
    /**
     * Atributo MessageText
     */
    @Column(name = "messagetext")
    private String messageText;

    /**
     * Relación Muchos a uno tabla Car
     */
    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Car car;
    /**
     * Relación muchos a uno tabla Client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    // Getters y Setters

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

}
