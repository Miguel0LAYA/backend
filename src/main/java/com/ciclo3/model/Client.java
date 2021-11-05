/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    /**
     * Atributo id Cliente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idClient;
    /**
     * Atributo email
     */
    @Column(name = "email")
    private String email;
    /**
     * Atributo password
     */
    @Column(name = "password")
    private String password;
    /**
     * Atributo Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo Age
     */
    @Column(name = "age")
    private int age;

    /**
     * Relación Uno a muchos tabla messages
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    /**
     * Relación Uno a muchos tabla reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

     // Getters y Setters
    
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   public List<Message> getMessages() {
        return messages;
    }

    /**
     * Setter Messages
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter Reservations
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Setter Reservations
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

