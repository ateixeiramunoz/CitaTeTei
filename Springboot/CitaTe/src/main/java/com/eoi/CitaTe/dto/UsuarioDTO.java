package com.eoi.CitaTe.dto;


import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empleado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String email;
    private String pass;
    private boolean activo;

    String tipoAlta;
    private Cliente cliente;

    private Empleado empleado;


}
