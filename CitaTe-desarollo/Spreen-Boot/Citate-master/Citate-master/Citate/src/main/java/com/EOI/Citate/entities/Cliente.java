package com.EOI.Citate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {


    @Id
    private long id;

    private String nombre;



}
