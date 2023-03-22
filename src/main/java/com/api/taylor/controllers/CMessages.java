package com.api.taylor.controllers;

import com.api.taylor.models.TDemandes;
import com.api.taylor.models.TMessages;
import com.api.taylor.repository.RDemandes;
import com.api.taylor.repository.RMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class CMessages {

    @Autowired
    private RMessages rMessages;

    @GetMapping()
    public List<TMessages> findAll() {
        return (List<TMessages>) rMessages.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TMessages> findById(@PathVariable(value = "id") long id) {
        Optional<TMessages> messages = rMessages.findById(id);

        if(messages.isPresent()) {
            return ResponseEntity.ok().body(messages.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TMessages save(@Validated @RequestBody TMessages messages) {
        return rMessages.save(messages);
    }


    @PutMapping()
    public ResponseEntity<TMessages> update(@Validated @RequestBody TMessages messages){
        return new ResponseEntity<>(rMessages.save(messages), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TMessages messages) {
        rMessages.deleteById(messages.getId());
        return  "Ok" ;
    }
}
