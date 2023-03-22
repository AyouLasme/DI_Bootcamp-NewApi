package com.api.taylor.controllers;

import com.api.taylor.models.TCompetencies;
import com.api.taylor.models.TCustomers;
import com.api.taylor.repository.RCompetencies;
import com.api.taylor.repository.RCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/competencies")
public class CCompetencies {

    @Autowired
    private RCompetencies rCompetencies;

    @GetMapping()
    public List<TCompetencies> findAll() {
        return (List<TCompetencies>) rCompetencies.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TCompetencies> findById(@PathVariable(value = "id") long id) {
        Optional<TCompetencies> competencies = rCompetencies.findById(id);

        if(competencies.isPresent()) {
            return ResponseEntity.ok().body(competencies.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TCompetencies save(@Validated @RequestBody TCompetencies competencies) {
        return rCompetencies.save(competencies);
    }


    @PutMapping()
    public ResponseEntity<TCompetencies> update(@Validated @RequestBody TCompetencies competencies){
        return new ResponseEntity<>(rCompetencies.save(competencies), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TCompetencies competencies){
        rCompetencies.deleteById(competencies.getId());
        return "OK" ;
    }
}
