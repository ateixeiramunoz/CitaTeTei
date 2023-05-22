package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa", nullable = false)
    private Long id;

    private String nombreEmpresa;
    private String cif;
    @Embedded
    private Direccion direccion;
    private String descripcionEmpresa;
    @Embedded
    private Contacto contacto;
    @Lob
    private byte[] logoEmpresa;

//    private Set<String> tipoEmpresa = new HashSet;
//    private MetodoPagoMensual metodoPagoMensual;
//    private Pago pago;

}