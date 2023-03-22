package com.api.taylor.controllers;

import com.api.taylor.models.TImages;
import com.api.taylor.models.TMessages;
import com.api.taylor.repository.RImages;
import com.api.taylor.repository.RMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/images")
public class CImages {
    @Autowired
    private RImages rImages;

    @GetMapping()
    public List<TImages> findAll() {
        return (List<TImages>) rImages.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TImages> findById(@PathVariable(value = "id") long id) {
        Optional<TImages> images = rImages.findById(id);

        if(images.isPresent()) {
            return ResponseEntity.ok().body(images.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TImages save(@Validated @RequestBody TImages images) {
        return  rImages.save(images);

    }


    @PutMapping()
    public ResponseEntity<TImages> update(@Validated @RequestBody TImages images){
        return new ResponseEntity<>(rImages.save(images), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TImages images) {
        rImages.deleteById(images.getId());
        return "Ok" ;
    }


}
