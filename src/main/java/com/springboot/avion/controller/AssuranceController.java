package com.springboot.avion.controller;

import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.model.Assurance;
import com.springboot.avion.service.AssuranceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


    @RestController
    @CrossOrigin
    @RequestMapping("/assurances")
    public class AssuranceController {
        private final AssuranceService assuranceService;

        public AssuranceController(AssuranceService assuranceService) {
            this.assuranceService = assuranceService;
        }

}
