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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competencies")
@JsonIdentityInfo(scope = TCompetencies.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TCompetencies implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name ="title", length = 60)
    private String title;



    /*jointure bidirectionnelle de  la classe TTaylors avec  la classe TCompetencies
       un tailleur peut avoir une ou plusieurs competences et une competences peut appartenir
         à un ou plusieurs tailleurs */
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIdentityReference(alwaysAsId = true)
    @JoinTable( name = "competencies_users",
            joinColumns = @JoinColumn( name = "competency_fk" ),
            inverseJoinColumns = @JoinColumn( name = "user_fk" ) )
    private List<TTaylors> taylors;

}
