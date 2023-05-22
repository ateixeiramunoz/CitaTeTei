package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", nullable = false)
    private Long id;
    private boolean estadoReserva;
//    private DateTimeFormat fechaReserva;
    private double hora_inicio;
    private double hora_fin;
//    private Valoracion valoracion;
//    private Disponibilidad disponibilidad;
//    private Cliente cliente;
//    private Servicio servicio;

}