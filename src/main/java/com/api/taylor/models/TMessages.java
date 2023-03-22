package com.api.taylor.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;


import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
@JsonIdentityInfo(scope = TMessages.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TMessages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "dateMsg", columnDefinition = "timestamp")
    private Date dateMsg;

    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "reveiver_fk", referencedColumnName = "id")
    private TUsers sender;

    @ManyToOne()
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "sender_fk", referencedColumnName = "id")
    private TUsers receiver;



}
