package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Empleado;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
    private void init(){
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
