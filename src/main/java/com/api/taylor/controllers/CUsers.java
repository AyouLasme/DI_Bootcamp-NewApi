package com.api.taylor.controllers;

import com.api.taylor.models.*;
import com.api.taylor.modules.Module;
import com.api.taylor.repository.RCustomers;
import com.api.taylor.repository.RTaylors;
import com.api.taylor.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TimerTask;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class CUsers {

    @Autowired
    private RCustomers rCostomers;
    @Autowired
    private RTaylors rTaylors;
    @Autowired
    private RUsers rUsers;

    @GetMapping()
    public List<TUsers> findAll() {
        return (List<TUsers>) rUsers.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TUsers> findById(@PathVariable(value = "id") long id) {
        Optional<TUsers> users = rUsers.findById(id);

        if(users.isPresent()) {
            return ResponseEntity.ok().body(users.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("login")
    public ResponseEntity<TUsers> login(@RequestBody @Validated TLoginPayLoad loginPayLoad) {
        Optional<TUsers> user = rUsers.findByEmailAndPassword(loginPayLoad.getEmail(), loginPayLoad.getPassword() );
        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping()
    public TUsers save(@Validated @RequestBody TUsers tUser) {
        //Crypter le mot de passe
        String  pwd = tUser.getPassword() ;
        tUser.setPassword(Module.hashPassword(pwd));

        //savegarder
        return rUsers.save(tUser)  ;
    }

    @PutMapping()
    public ResponseEntity<TUsers> update(@Validated @RequestBody TUsers users){
        return new ResponseEntity<>(rUsers.save(users), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TUsers users){
        rUsers.deleteById(users.getId());
        return "Ok" ;
    }
}
