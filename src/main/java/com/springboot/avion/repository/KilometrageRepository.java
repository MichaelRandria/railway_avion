package com.springboot.avion.repository;

import com.springboot.avion.model.Avion;
import com.springboot.avion.model.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KilometrageRepository extends JpaRepository<Kilometrage,Integer> {
    public List<Kilometrage> findAllByAvion(Avion avion);
}
