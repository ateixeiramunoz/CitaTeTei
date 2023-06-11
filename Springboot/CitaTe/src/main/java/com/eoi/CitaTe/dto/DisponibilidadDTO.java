package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadDTO {

    private Long id;
    private String fecha;
    private Time hora_inicio_mañana;
    private Time hora_fin_mañana;
    private Time hora_inicio_tarde;
    private Time hora_fin_tarde;

    //private Empleado empleado;
}
