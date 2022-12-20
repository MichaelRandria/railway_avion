package com.springboot.avion.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "entretienavion")
public class EntretienAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "identretien")
    Entretien entretien;

    @ManyToOne
    @JoinColumn(name = "idavion")
    Avion avion;

    @Column(name = "dateentretien")
    private Date dateEntretien;
}
