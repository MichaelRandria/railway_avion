package com.springboot.avion.repository;

import com.springboot.avion.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvionRepository extends JpaRepository<Avion,Integer> {
    @Query(value = "select avion.* from (select *, age(datefin ,now()) perim from assurance) tab join avion on avion.id = tab.idavion where perim < ?1 * INTERVAL '1 mons' and datefin >= now()", nativeQuery = true)
    List<Avion> getFinAssurance(int mois);
}
