package com.eoi.CitaTe.dto;

import com.eoi.CitaTe.entities.Cliente;
import com.eoi.CitaTe.entities.Usuario;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private String telefono;

    @Lob
    private byte[] icono;

    private String email;
    private String pass;
    private Usuario usuario;

    public ClienteDTO(Cliente cliente) {
        this.setId(usuario.getId());
        this.setNombreCliente(cliente.getNombreCliente());
        this.setApellido1Cliente(cliente.getApellido1Cliente());
        this.setApellido2Cliente(cliente.getApellido1Cliente());
        this.setEmail(usuario.getEmail());
        this.setPass(usuario.getPass());
    }
}
