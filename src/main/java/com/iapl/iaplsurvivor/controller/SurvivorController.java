package com.iapl.iaplsurvivor.controller;

import com.iapl.iaplsurvivor.util.LocationChangeRequest;
import com.iapl.iaplsurvivor.util.RestResponse;
import com.iapl.iaplsurvivor.model.Survivor;
import com.iapl.iaplsurvivor.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SurvivorController {
    @Autowired
    private SurvivorService service;

    @PostMapping("/add_survivor")
    public Survivor addSurvivor(@RequestBody Survivor survivor){
        return service.saveSurvivor(survivor);
    }

    @GetMapping("/survivors")
    public List<Survivor> findAllSurvivors(){
        return service.allSurvivors();
    }

    @PutMapping("/update_location/{id}")
    public RestResponse updateLocation(@PathVariable(value = "id") int Id,  @RequestBody LocationChangeRequest location){
        return service.updateSurvivorLocation(location, Id);
    }

    @GetMapping("/percentage-infected")
    public RestResponse percentageInfected(){
        return service.PercentageInfected();
    }

    @GetMapping("/percentage-uninfected")
    public RestResponse percentageUnInfected(){
        return service.PercentageUnInfected();
    }

    @GetMapping("/infected-survivors")
    public RestResponse getAllInfectedSurvivors(){
        return service.getAllInfectedSurvivors();
    }

    @GetMapping("/uninfected-survivors")
    public RestResponse getAllUnInfectedSurvivors(){
        return service.getAllNonInfectedSurvivors();
    }


    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
