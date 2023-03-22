package com.api.taylor.controllers;

import com.api.taylor.models.TCustomers;
import com.api.taylor.models.TReponse;
import com.api.taylor.repository.RCustomers;
import com.api.taylor.repository.RReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/reponses")
public class CReponse {

    @Autowired
    private RReponse rReponse;

    @GetMapping()
    public List<TReponse> findAll() {
        return (List<TReponse>) rReponse.findAll();

    }


    @GetMapping("/findByDemande/{id}")
    public List<TReponse> findByDemande(@PathVariable(value = "id") long id) {
        return (List<TReponse>) rReponse.findByDemande(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TReponse> findById(@PathVariable(value = "id") long id) {
        Optional<TReponse> tReponse = rReponse.findById(id);

        if(tReponse.isPresent()) {
            return ResponseEntity.ok().body(tReponse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TReponse save(@Validated @RequestBody TReponse reponse) {
        return rReponse.save(reponse);
    }


    @PutMapping()
    public ResponseEntity<TReponse> update(@Validated @RequestBody TReponse reponse){
        return new ResponseEntity<>(rReponse.save(reponse), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TReponse reponse){
        rReponse.deleteById(reponse.getId());
        return "Ok" ;
    }
}
