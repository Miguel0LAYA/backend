/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.service;
import com.ciclo3.model.Gama;
import com.ciclo3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MIGUEL
 */
@Service
public class GamaService {
    /**
     * Inicializamos el repositorio Gama
     */
    @Autowired
    private GamaRepository gamaRepository;

    /**
     * Método para obtener todas las gamas del repositorio
     *
     * @return
     */
    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    /**
     * Método para obtener una gama por id
     *
     * @param id
     * @return
     */
    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    /**
     * Método para agregar una gama
     *
     * @param gama
     * @return
     */
    public Gama save(Gama gama) {
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> evt = gamaRepository.getGama(gama.getIdGama());
            if (evt.isEmpty()) {
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }

    /**
     * Método para actualizar una Gama
     *
     * @param gama
     * @return
     */
    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> evnt = gamaRepository.getGama(gama.getIdGama());
            if (!evnt.isEmpty()) {
                if (gama.getName() != null) {
                    evnt.get().setName(gama.getName());
                }
                if (gama.getDescription() != null) {
                    evnt.get().setDescription(gama.getDescription());
                }
                gamaRepository.save(evnt.get());
                return evnt.get();
            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }

    /**
     * Método para eliminar una Gama
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Boolean flag = getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return flag;
    }
}
