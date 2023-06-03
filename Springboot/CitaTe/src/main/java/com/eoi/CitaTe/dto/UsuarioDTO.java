package com.eoi.CitaTe.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String email;
    private String pass;
    private boolean activo;
    private Long cliente;

}
