package com.springboot.avion.repository;

import com.springboot.avion.model.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {

}
