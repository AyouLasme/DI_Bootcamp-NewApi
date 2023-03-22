package com.api.taylor.models;

import com.fasterxml.jackson.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
@JsonIdentityInfo(scope = TUsers.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TUsers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "firstname", length = 60 )
    protected String firstname;

    @Column(name = "lastname", length = 60 )
    protected  String lastname;

    @Column(name = "email", length = 150 )
    protected  String email;

    @Column(name = "tel", length = 20 )
    protected  String tel;

    @Column(name = "password", length = 100 )
    protected  String password;

    @Column(name = "adresse", length = 100 )
    protected String adresse;

    @Column(name = "role", length = 10)
    protected String role = "";


    @Column(name = "admin", nullable = false, columnDefinition = "boolean default false")
    protected boolean admin = false;

    @Column(name = "sexe", length = 10)
    protected  String sexe;



    // Relation unidirectionnelle entre TUsers et TMunicipality
    // un utilisateur peut appartenir a une et une seule commune
    @ManyToOne()
    @JoinColumn (name = "municipality_fk",referencedColumnName = "id")
    protected TMunicipality municipality;



    /*jointure unidirectionnelle de  la classe TUsers avec  la classe TMessages
   un utilisateur peut envoyer et ou recevoir un ou plusieurs messages*/
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TMessages> receivedMessages;



    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private List<TMessages> sentMessages;






}
