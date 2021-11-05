/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.web;

import com.ciclo3.model.Message;
import com.ciclo3.service.MessageService;
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
@RequestMapping("/api/Message/")
public class MessageWeb {

    /**
     * Inicializamos Api Message
     */
    @Autowired
    private MessageService messageApi;

    /**
     * Método para obtener todos los mensajes desde URL
     *
     * @return
     */
    @GetMapping("all")
    public List<Message> getAll() {
        return messageApi.getAll();
    }

    /**
     * Método para obtener un mensajes por id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return messageApi.getMessage(id);
    }

    /**
     * Método para agregar un mensaje desde URL
     *
     * @param message
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageApi.save(message);
    }

    /**
     * Método para actualizar un mensaje
     *
     * @param message
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageApi.update(message);
    }

    /**
     * Método para eliminar un mensaje
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return messageApi.delete(id);
    }
}
