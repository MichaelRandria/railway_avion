package com.springboot.avion.service;

import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.exception.ResourceNotFoundException;
import com.springboot.avion.model.Avion;
import com.springboot.avion.repository.AvionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvionService {
    AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {
        super();
        this.avionRepository = avionRepository;
    }

    public Avion saveAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    public Avion getById(Integer id) {
        Optional<Avion> avion=avionRepository.findById(id);
        return avion.orElse(null);
    }

    public List<Avion> getAll() {
        return avionRepository.findAll();
    }

    public Avion updateAvion(Avion avion, Integer id) {
        ModelJSON modelJSON=new ModelJSON();
        Optional<Avion> avionExistant=avionRepository.findById(id);
        if(avionExistant.isEmpty()){
            return null;
        }

        avionExistant.get().setMatricule(avion.getMatricule());
        return avionRepository.save(avionExistant.get());
    }

    public void deleteAvion(Integer id) {
        avionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Avion","Id",id));
        avionRepository.deleteById(id);
    }

    public List<Avion> getExpireMois(int mois) {
        return avionRepository.getFinAssurance(mois);
    }
}
