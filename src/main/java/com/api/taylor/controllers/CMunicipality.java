package com.api.taylor.controllers;

import com.api.taylor.models.TMunicipality;
import com.api.taylor.repository.RMunicipality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/municipalities")
public class CMunicipality {
    @Autowired
    private RMunicipality rMunicipality;

    @GetMapping()
    public List<TMunicipality> findAll() {
        return (List<TMunicipality>) rMunicipality.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TMunicipality> findById(@PathVariable(value = "id") long id) {
        Optional<TMunicipality> municipality = rMunicipality.findById(id);

        if(municipality.isPresent()) {
            return ResponseEntity.ok().body(municipality.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TMunicipality save(@Validated @RequestBody TMunicipality municipality) {
        return rMunicipality.save(municipality);
    }


    @PutMapping()
    public ResponseEntity<TMunicipality> update(@Validated @RequestBody TMunicipality municipality){
        return new ResponseEntity<>(rMunicipality.save(municipality), HttpStatus.CREATED);
    }

   @DeleteMapping()
    public String delete(@Validated @RequestBody TMunicipality municipality){
        rMunicipality.deleteById(municipality.getId());
        return "Ok" ;
    }

}
