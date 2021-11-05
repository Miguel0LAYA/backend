package com.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;


/**
 *
 * @author CarlinGebyte
 */
@Entity
@Table(name = "gama")
public class Gama {
    /**
     * Atributo idGama
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idGama;
    /**
     * Atributo Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo Description
     */
    @Column(name = "description")
    private String description;
    /**
     * Relación uno a muchos de la tabla Car
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    private List<Car> cars;

    // Getters y Setters

    public Integer getIdGama() {
        return idGama;
    }

    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
}

