package com.api.taylor.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipalities")
@JsonIdentityInfo(scope = TMunicipality.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TMunicipality implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    private String libelle;


    @ManyToOne()
    @JoinColumn (name = "city_fk",referencedColumnName = "id")
    private TCity city;


    /*jointure unidirectionnelle de  la classe TMunicipality avec  la classe TUser
    une commune peut appartenir à un ou plusieurs utilisateurs*/
    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TUsers> users;


    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TDemandes> demandes;

}
