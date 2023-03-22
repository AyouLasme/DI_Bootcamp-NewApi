package com.api.taylor.controllers;

import com.api.taylor.models.TCity;
import com.api.taylor.repository.RCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/city")
public class CCity {

    @Autowired
    private RCity rCity;

    @GetMapping()
    public List<TCity> findAll() {
        return (List<TCity>) rCity.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TCity> findById(@PathVariable(value = "id") long id) {
        Optional<TCity> city = rCity.findById(id);

        if(city.isPresent()) {
            return ResponseEntity.ok().body(city.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TCity save(@Validated @RequestBody TCity city) {
         return rCity.save(city);
    }


    @PutMapping()
    public ResponseEntity<TCity> update(@Validated @RequestBody TCity city){
        return new ResponseEntity<>(rCity.save(city), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public void delete(@Validated @RequestBody TCity city){
        rCity.deleteById(city.getId());
    }


}
