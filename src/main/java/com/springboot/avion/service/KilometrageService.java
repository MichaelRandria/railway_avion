package com.springboot.avion.service;

import com.springboot.avion.exception.ResourceNotFoundException;
import com.springboot.avion.model.Avion;
import com.springboot.avion.model.Kilometrage;
import com.springboot.avion.repository.KilometrageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KilometrageService {
    private final KilometrageRepository kilometrageRepository;

    public KilometrageService(KilometrageRepository kilometrageRepository) {
        super();
        this.kilometrageRepository = kilometrageRepository;
    }

    public Kilometrage saveKilometrage(Kilometrage kilometrage) {
        return kilometrageRepository.save(kilometrage);
    }

    public Kilometrage getById(Integer id) {
        Optional<Kilometrage> kilometrage=kilometrageRepository.findById(id);
        return kilometrage.orElse(null);
    }

    public List<Kilometrage> getAll() {
        return kilometrageRepository.findAll();
    }

    public Kilometrage updateKilometrage(Kilometrage kilometrageUpdate,Integer id) {
        Optional<Kilometrage> kilometrageExistant=kilometrageRepository.findById(id);
        if (kilometrageExistant.isEmpty()) {
            return null;
        }
        kilometrageExistant.get().setDateKilometrage(kilometrageUpdate.getDateKilometrage());
        kilometrageExistant.get().setAvion(kilometrageUpdate.getAvion());
        kilometrageExistant.get().setDebutKm(kilometrageUpdate.getDebutKm());
        kilometrageExistant.get().setFinKm(kilometrageUpdate.getFinKm());
        return kilometrageRepository.save(kilometrageExistant.get());
    }

    public void deleteKilometrage(Integer id) {
        kilometrageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Kilometrage","Id",id));
        kilometrageRepository.deleteById(id);
    }
    public List<Kilometrage> getByAvion(Avion avion) {
        if(kilometrageRepository.findAllByAvion(avion).isEmpty()){
            return null;
        }
        return kilometrageRepository.findAllByAvion(avion);
    }
}
