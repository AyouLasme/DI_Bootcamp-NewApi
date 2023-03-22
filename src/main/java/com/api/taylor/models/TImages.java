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
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TImages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private String link;

    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn (name = "demande_fk",referencedColumnName = "id")
    private TDemandes demande;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JsonIdentityReference(alwaysAsId = true)
//    @JoinColumn (name = "user_fk",referencedColumnName = "id")
//    private TUsers user;
}
