package com.api.taylor.controllers;

import com.api.taylor.models.TTaylors;
import com.api.taylor.modules.Module;
import com.api.taylor.repository.RTaylors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/taylors")
public class CTaylors {

    @Autowired
    private RTaylors rTaylors;

    @GetMapping()
    public List<TTaylors> findAll() {
        return (List<TTaylors>) rTaylors.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TTaylors> findById(@PathVariable(value = "id") long id) {
        Optional<TTaylors> taylors = rTaylors.findById(id);

        if(taylors.isPresent()) {
            return ResponseEntity.ok().body(taylors.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TTaylors save(@Validated @RequestBody TTaylors taylors) {
        //Crypter le mot de passe
        String  pwd = taylors.getPassword() ;
        //taylors.setPassword(Module.hashPassword(pwd));

        //savegarder
        return rTaylors.save(taylors);
    }

    @PutMapping()
    public ResponseEntity<TTaylors> update(@Validated @RequestBody TTaylors taylors){
        return new ResponseEntity<>(rTaylors.save(taylors), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TTaylors taylors){
        rTaylors.deleteById(taylors.getId());
        return  "Ok" ;
    }
}
