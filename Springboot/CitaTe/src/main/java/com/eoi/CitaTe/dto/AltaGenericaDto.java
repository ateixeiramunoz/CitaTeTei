package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Empleado;
import com.eoi.CitaTe.entities.Empresa;
import com.eoi.CitaTe.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AltaGenericaDto {

    String tipoalta;
    UsuarioDTO usuario;
    ClienteDTO cliente;
    EmpleadoDTO empleado;
    EmpresaDTO empresa;

    public AltaGenericaDto() {
        UsuarioDTO usuario = new UsuarioDTO();
        ClienteDTO cliente = new ClienteDTO();
        EmpleadoDTO empleado = new EmpleadoDTO();
        EmpresaDTO empresa = new EmpresaDTO();
    }

    public AltaGenericaDto(String tipoalta, UsuarioDTO usuario, ClienteDTO cliente, EmpleadoDTO empleado, EmpresaDTO empresa) {
        this.tipoalta = tipoalta;
        this.usuario = usuario;
        this.cliente = cliente;
        this.empleado = empleado;
        this.empresa = empresa;
    }


}
