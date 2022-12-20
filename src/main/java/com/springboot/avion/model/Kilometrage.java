package com.springboot.avion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idavion")
    Avion avion;

    @Column(name = "datekilometrage")
    Date dateKilometrage;

    @Column(name = "debutkm")
    Double debutKm;

    @Column(name = "finkm")
    Double finKm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
