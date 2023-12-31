package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

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
    private LocalDate fechaReserva;
    private String hora_inicio;
    private String hora_fin;


    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "valoracion_id", referencedColumnName = "id_valoracion")
    private Valoracion valoracion;



//    private Disponibilidad disponibilidad; no hacer fk

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;


////////////////////////////////////////////////////
    @Transient
    private Servicio servicio;
    ///////////////////////////////////////////

}


