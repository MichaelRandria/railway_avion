package com.springboot.avion.controller;

import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.service.KilometrageService;
import com.springboot.avion.exception.ErrorMessage;
import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.model.Kilometrage;
import com.springboot.avion.model.Avion;
import com.springboot.avion.service.KilometrageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/kilometrages")
public class KilometrageController {
    private final KilometrageService kilometrageService;

    public KilometrageController(KilometrageService kilometrageService) {
        super();
        this.kilometrageService = kilometrageService;
    }

    @PostMapping()
    public ModelJSON saveKilometrage(@RequestBody Kilometrage kilometrage) {
        kilometrageService.saveKilometrage(kilometrage);
        ModelJSON modelJSON = new ModelJSON();
        modelJSON.setData(modelJSON);
        return modelJSON;
    }

    @GetMapping
    public ModelJSON getAllKilometrage() {
        ModelJSON modelJSON = new ModelJSON();
        modelJSON.setData(kilometrageService.getAll());
        return modelJSON;
    }

    @GetMapping("/{id}")
    public ModelJSON getKilometrageById(@PathVariable("id") Integer id) {
        Kilometrage kilometrage = kilometrageService.getById(id);
        ModelJSON modelJSON = new ModelJSON();
        if (kilometrage != null) {
            modelJSON.setData(kilometrage);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("404", "ID not found");
            modelJSON.setError(errorMessage);
        }
        return modelJSON;
    }

    @PutMapping("/{id}")
    public ModelJSON updateKilometrage(@PathVariable("id") Integer id, @RequestBody Kilometrage kilometrage) {
        kilometrage = kilometrageService.updateKilometrage(kilometrage, id);
        ModelJSON modelJSON = new ModelJSON();
        if (kilometrage == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "ID not found");
            modelJSON.setError(errorMessage);
        } else {
            modelJSON.setData(kilometrage);
        }
        return modelJSON;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKilometrage(@PathVariable("id") Integer id) {
        kilometrageService.deleteKilometrage(id);
        return new ResponseEntity<>("Kilometrage supprime", HttpStatus.OK);
    }
}
