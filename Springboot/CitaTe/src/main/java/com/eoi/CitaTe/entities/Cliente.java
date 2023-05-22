package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false)
    private Long id;
    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private String telefono;
    @Lob
    private byte[] icono;
    //private Usuario usuario;



}