package com.springboot.avion.repository;

import com.springboot.avion.model.EntretienAvion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntretienAvionRepository extends JpaRepository<EntretienAvion, Integer> {
}
