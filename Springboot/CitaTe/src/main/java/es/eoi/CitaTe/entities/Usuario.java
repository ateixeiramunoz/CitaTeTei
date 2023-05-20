package es.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Long id;

    private String email;
    private String password;
    private boolean activo;
    private Empleado empleado;
    private Cliente cliente;
    private Rol rol;






}