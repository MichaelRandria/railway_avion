package com.springboot.avion.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "photo")
    private String photo;

    public Integer getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
