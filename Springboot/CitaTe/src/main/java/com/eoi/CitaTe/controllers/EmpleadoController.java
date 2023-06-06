package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.ClienteDTO;
import com.eoi.CitaTe.dto.UsuarioDTO;
import com.eoi.CitaTe.entities.Empleado;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.empleado}")
public class EmpleadoController extends MiControladorGenerico<Empleado> {

    @Value("${url.empleado}")
    private String urlBase;
    private String entityName = "empleados";

    public EmpleadoController(){
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        ClienteDTO clienteDTO = new ClienteDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);
        model.addAttribute("clienteDTO", clienteDTO);
//        model.addAttribute("url", url);
        model.addAttribute("entityName", entityName);

        return "usuarios/altaUsuario"; // Nombre de la plantilla para mostrar todas las entidades
    }



}
