package com.springboot.avion.repository;

import com.springboot.avion.model.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntretienRepository extends JpaRepository<Entretien, Integer> {
}
