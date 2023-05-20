package es.eoi.CitaTe.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado", nullable = false)
    private Long id;
    private String nombreEmpleado;
    private String apellido1Empleado;
    private String apellido2Empleado;

    private Empresa empresa;
    private Usuario usuario;

}