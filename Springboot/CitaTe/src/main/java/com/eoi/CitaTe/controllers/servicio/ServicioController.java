package com.eoi.CitaTe.controllers.servicio;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.entities.Servicio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.servicio}")
public class ServicioController extends MiControladorGenerico<Servicio> {
    @Value("${url.servicio}")
    private String urlBase;
    private String entityName = "servicios";

    public ServicioController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
