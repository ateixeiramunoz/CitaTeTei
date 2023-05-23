package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "facturacion")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_facturacion", nullable = false)
    private Long id;
    private Date fecha;

    //@OneToOne(mappedBy = "Facturacion")
   //private Pago pago;

}