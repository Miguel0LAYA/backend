/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository;

import com.ciclo3.model.Client;
import com.ciclo3.repository.crud.ClientCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Repository
public class ClientRepository {
    /**
     * Atributo Repositorio CLient
     */
    @Autowired
    private ClientCrud clientCrud;

    /**
     * Método para encontrar todos los clientes del repositorio
     *
     * @return
     */
    public List<Client> getAll() {
        return (List<Client>) clientCrud.findAll();
    }

    /**
     * Método para encontrar un cliente por id
     *
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id) {
        return clientCrud.findById(id);
    }

    /**
     * Método para agregar un cliente
     *
     * @param client
     * @return
     */
    public Client save(Client client) {
        return clientCrud.save(client);
    }

    /**
     * Método para eliminar un cliente
     *
     * @param client
     */
    public void delete(Client client) {
        clientCrud.delete(client);
    }
}

