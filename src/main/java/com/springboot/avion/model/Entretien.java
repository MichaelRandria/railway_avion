package com.springboot.avion.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "typeentretien")
    private String typeEntretien;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeEntretien() {
        return typeEntretien;
    }

    public void setTypeEntretien(String typeEntretien) {
        this.typeEntretien = typeEntretien;
    }
}
