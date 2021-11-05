/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.repository;
import com.ciclo3.model.Message;
import com.ciclo3.repository.crud.MessageCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Repository
public class MessageRepository {
    /**
     * Atributo Repositorio Message
     */
    @Autowired
    private MessageCrud messageCrud;

    /**
     * Método para obtener todos los mensajes del repositorio
     *
     * @return
     */
    public List<Message> getAll() {
        return (List<Message>) messageCrud.findAll();
    }

    /**
     * Método para obtener un mensaje por id
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id) {
        return messageCrud.findById(id);
    }

    /**
     * Método para agregar un mensaje
     *
     * @param message
     * @return
     */
    public Message save(Message message) {
        return messageCrud.save(message);
    }

    /**
     * Método para eliminar un mensaje
     *
     * @param message
     */
    public void delete(Message message) {
        messageCrud.delete(message);
    }
}

