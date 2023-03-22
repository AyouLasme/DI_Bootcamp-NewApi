package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TRegisterPayLoad {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String tel;
    private String password;
    private String adresse;
    private String role;
    private boolean admin;
    private String sexe;
    private String category;
    private String galery;
    private boolean isActive;


    private TCompetencies conpetencies;

}
