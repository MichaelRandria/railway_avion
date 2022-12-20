package com.springboot.avion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nomadmin")
    String nomadmin;

    @Column(name = "mdpadmin")
    String mdpadmin;

    @Column(name = "email")
    String email;


}
