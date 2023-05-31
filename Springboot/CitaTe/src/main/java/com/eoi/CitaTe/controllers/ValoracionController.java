package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.entities.Valoracion;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.valoracion}")
public class ValoracionController extends MiControladorGenerico<Valoracion> {
    @Value("${url.valoracion}")
    private String urlBase;
    private String entityName = "valoraciones";

    public ValoracionController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }
}
