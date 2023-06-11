package com.eoi.CitaTe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private boolean estadoReserva;
    private Date fechaReserva;
    private double hora_inicio;
    private double hora_fin;



//    private Valoracion valoracion;
//    private Cliente cliente;
//    private Servicio servicio;
}
