/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.service;
import com.ciclo3.model.Message;
import com.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Service
public class MessageService {
    /**
     * Inicializamos el repositorio Message
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Método para obtener todos los mensajes del repositorio
     *
     * @return
     */
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    /**
     * Método para obtener un mensaje por id
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    /**
     * Método para agregar un mensaje
     *
     * @param message
     * @return
     */
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> evt = messageRepository.getMessage(message.getIdMessage());
            if (evt.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    /**
     * Método para actualizar un mensaje
     *
     * @param message
     * @return
     */
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> evnt = messageRepository.getMessage(message.getIdMessage());
            if (!evnt.isEmpty()) {
                if (message.getMessageText() != null) {
                    evnt.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(evnt.get());
                return evnt.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * Método para eliminar un mensaje
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Boolean flag = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return flag;
    }
}
