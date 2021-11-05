/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author MIGUEL
 */

@Entity
@Table(name = "car")
public class Car implements Serializable {
    /**
     * Atributo id del carro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idCar;
    /**
     * Atributo nombre del carro
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo marca del carro
     */
    @Column(name = "brand")
    private String brand;
    /**
     * Atributo Año del carro
     */
    @Column(name = "year")
    private int year;
    /**
     * Atributo descripción del carro
     */
    @Column(name = "description")
    private String description;

    /**
     * Relación Muchos a uno tabla Gama
     */
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    private Gama gama = null;
    /**
     * Relación uno a muchos tabla mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})
    private List<Message> messages;
    /**
     * Relación uno a muchos tabla reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<Reservation> reservations;

    //Métodos getter y setter

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    

   }