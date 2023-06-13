package com.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = true)
    private Long id;

    private String email;
    private String pass;
    @Basic(optional = false)
    private boolean activo;

    // Utilizamos  UUID.randomUUID de java util para generar el token de forma aleatoria cada vez que se cree un usuario
    // el token lo utilizaremos en el reset password cuando enviamos el correo al usuario para el cambio de pass
    private String token = UUID.randomUUID().toString();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id_empleado")
    private Empleado empleado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Cliente cliente;



    //@OneToMany
    //private Rol rol;








}