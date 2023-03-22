package com.api.taylor.controllers;

import com.api.taylor.models.*;
import com.api.taylor.repository.RDemandes;
import com.api.taylor.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/demandes")
public class CDemandes {

    @Autowired
    private RDemandes rDemandes;

    @Autowired
    private RUsers rUsers;


    @GetMapping()
    public List<TDemandes> findAll() {
        return (List<TDemandes>) rDemandes.findAll();

    }


    //Methode de recuperation des demandes en fonction de la municipalité
    @GetMapping("/municipality/{id}")
    public List<TDemandes> findByMunicipality(@PathVariable(value = "id") long id) {
        return (List<TDemandes>) rDemandes.findByMunicipality(id);
    }

    //Methode de recuperation des demandes par le sender
    @GetMapping("/sender/{id}")
    public List<TDemandes> findBySender(@PathVariable(value = "id") long id) {
        return (List<TDemandes>) rDemandes.findBySender(id);
    }

    //Methode de recuperation des demandes par le receveur
    @GetMapping("/receiver/{id}")
    public List<TDemandes> findByReceiver(@PathVariable(value = "id") long id) {
        return (List<TDemandes>) rDemandes.findByReceiver(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TDemandes> findById(@PathVariable(value = "id") long id) {
        Optional<TDemandes> demandes = rDemandes.findById(id);

        if(demandes.isPresent()) {
            return ResponseEntity.ok().body(demandes.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    //@PostMapping(path= {""}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @PostMapping()
    public TDemandes save(@Validated @RequestBody TDemandes demandes) {
       return rDemandes.save(demandes);
    }


    @PutMapping(consumes = "application/json;charset=UTF-8")
    public ResponseEntity<TDemandes> update(@Validated @RequestBody TDemandes demandes){
        return new ResponseEntity<>(rDemandes.save(demandes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody TDemandes demandes){
        Optional<TDemandes> check = rDemandes.findById(id);
        if(check.isEmpty()){
            return new ResponseEntity<>("Current demande not found", HttpStatus.NOT_FOUND);
        }else{
            check.get().setContent(demandes.getContent());
            check.get().setCategory(demandes.getCategory());
            check.get().setImages(demandes.getImages());
            check.get().setObject(demandes.getObject());
            check.get().setMunicipality(demandes.getMunicipality());
            check.get().setContent(demandes.getContent());
            check.get().setDateDmd(demandes.getDateDmd());
            check.get().setDateRetrait(demandes.getDateRetrait());
            rDemandes.save(check.get());

            return new ResponseEntity<>("Data is updated", HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        rDemandes.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
