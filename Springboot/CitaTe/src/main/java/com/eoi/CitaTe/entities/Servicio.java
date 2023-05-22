package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servicio", nullable = false)
    private Long id;
    //private Empleado empleado;
    //private CatalogoDeServicio catalogoDeServicio; // NO HACER FK, PARA EVITAR RELACION CIRCULAR (TEC. MOD. DOM.)

}