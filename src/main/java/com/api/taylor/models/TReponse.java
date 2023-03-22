package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reponse")
@JsonIdentityInfo(scope = TReponse.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TReponse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "dateOffre", columnDefinition = "timestamp")
    private Date dateOffre;

    private double prixOffre;


    @ManyToOne()
    @JoinColumn(name = "demande_fk", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIdentityReference(alwaysAsId = true)
    private TDemandes demande;


    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = false)
    @JoinColumn(name = "sender_fk", referencedColumnName = "id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TTaylors sender;



}
