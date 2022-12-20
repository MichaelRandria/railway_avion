package com.springboot.avion.service;

import com.springboot.avion.model.Assurance;
import com.springboot.avion.repository.AssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceService {
    private final AssuranceRepository assuranceRepository;

    public AssuranceService(AssuranceRepository assuranceRepository) {
        super();
        this.assuranceRepository = assuranceRepository;
    }


}
