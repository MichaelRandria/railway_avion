package com.springboot.avion.controller;

import com.springboot.avion.service.AssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    import com.springboot.avion.exception.ErrorMessage;
import com.springboot.avion.exception.ModelJSON;
import com.springboot.avion.model.Avion;
import com.springboot.avion.service.KilometrageService;
import com.springboot.avion.service.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @CrossOrigin
    @RequestMapping("/avions")
    public class AvionController {
        private final AvionService avionService;

        private final KilometrageService kilometrageService;

        private final AssuranceService assuranceService;

        public AvionController(AvionService avionService, KilometrageService kilometrageService, AssuranceService assuranceService) {
            super();
            this.avionService = avionService;
            this.kilometrageService = kilometrageService;
            this.assuranceService = assuranceService;
        }

        @PostMapping()
        public ModelJSON saveAvion(@RequestBody Avion avion){
            ModelJSON modelJSON=new ModelJSON();
            modelJSON.setData(avionService.saveAvion(avion));
            return modelJSON;
        }

        @GetMapping("/assurances/{mois}")
        public ModelJSON getListeExpires(@PathVariable("mois") int mois){
            ModelJSON modelJSON= new ModelJSON();
//        List<Assurance> liste = assuranceService.getExpiresUn();
//        List<Avion> avionList=new ArrayList<>();
//        for(Assurance assurance:liste){
//            avionList.add(assurance.getAvion());
//        }
            List<Avion> avionList=avionService.getExpireMois(mois);
            modelJSON.setData(avionList);
            return modelJSON;
        }

        @GetMapping
        public ModelJSON getAllAvion(){
            ModelJSON modelJSON=new ModelJSON();
            modelJSON.setData(avionService.getAll());
            return modelJSON;
        }

        @GetMapping("/{id}")
        public ModelJSON getAvionById(@PathVariable("id") Integer id){
            ModelJSON modelJSON=new ModelJSON();
            Avion avion=avionService.getById(id);
            if(avion==null){
                ErrorMessage errorMessage=new ErrorMessage("404","ID not found");
                modelJSON.setError(errorMessage);
            }
            else{
                modelJSON.setData(avion);
            }
            return modelJSON;
        }

        @PutMapping("/{id}")
        public ModelJSON updateAvion(@PathVariable("id") Integer id,@RequestBody Avion avion){
            avion=avionService.updateAvion(avion, id);
            ModelJSON modelJSON=new ModelJSON();
            if(avion==null){
                ErrorMessage errorMessage=new ErrorMessage("404","ID not found");
                modelJSON.setError(errorMessage);
            }
            else{
                modelJSON.setData(avion);
            }
            return modelJSON;
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteAvion(@PathVariable("id") Integer id){
            avionService.deleteAvion(id);
            return new ResponseEntity<>("Avion supprime", HttpStatus.OK);
        }

        @GetMapping("/{id}/kilometrages")
        public ModelJSON getKilometrageByAvion(@PathVariable("id") Integer id){
            Avion avion=avionService.getById(id);
            ModelJSON modelJSON=new ModelJSON();
            if(avion==null){
                ErrorMessage errorMessage=new ErrorMessage("404","ID not found");
                modelJSON.setError(errorMessage);
            }
            else{
                modelJSON.setData(kilometrageService.getByAvion(avion));
            }
            return modelJSON;
        }

//    @PostMapping("/assurance")
//    public ModelJSON getAssuranceDelai(@RequestBody Integer mois){
//        List<Avion> avionList=assuranceService.getExpireMois(mois);
//        ModelJSON modelJSON=new ModelJSON();
//        modelJSON.setData(avionList);
//        return modelJSON;
//    }
//
//    @GetMapping("/assurance/{mois}")
//    public ModelJSON getAssuranceDelaiByMois(@PathVariable("mois") String mois){
//        System.out.println(mois);
//        Integer moisnumber=Integer.valueOf(mois);
//        List<Avion> avionList=assuranceService.getExpireMois(moisnumber);
//        ModelJSON modelJSON=new ModelJSON();
//        modelJSON.setData(avionList);
//        return modelJSON;
//    }
}
