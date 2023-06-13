package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_disponibilidad", nullable = false)
    private Long id;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date fecha;

    private String horaInicioManiana;
    private String horaFinManiana;
    private String horaInicioTarde;
    private String horaFinTarde;


   @OneToOne(mappedBy = "disponibilidad")
   private Empleado empleado;

}