/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.web;
import com.ciclo3.model.Client;
import com.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Client/")
public class ClientWeb {
    /**
     * Inicializamos Api Client
     */
    @Autowired
    private ClientService clientApi;

    /**
     * Método para obtener todos los clientes por URL
     *
     * @return
     */
    @GetMapping("all")
    public List<Client> getAll() {
        return clientApi.getAll();
    }

    /**
     * Método para obtener un cliente por id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return clientApi.getClient(id);
    }

    /**
     * Método para agregar un cliente desde URL
     *
     * @param client
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clientApi.save(client);
    }

    /**
     * Método
para actualizar un cliente
     * @param client
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientApi.update(client);
    }

    /**
     * Método para eliminar un cliente
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return clientApi.delete(id);
    }
}
