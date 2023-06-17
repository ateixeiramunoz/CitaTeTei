package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Servicio;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpleadoDTO {

    private String nombreEmpleado;
    private String apellido1Empleado;
    private String apellido2Empleado;
    private Empresa empresa;
    private Long disponibilidad_id;
    private Set<Servicio> serviciosdto = new HashSet<>();

}