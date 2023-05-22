package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_menu", nullable = false)
    private Long id;
    private String url;
    private String descripcion;
    private boolean activo;

}