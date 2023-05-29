package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Facturacion;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.facturacion}")
public class FacturacionController extends MiControladorGenerico<Facturacion> {
    @Value("${url.facturacion}")
    private String urlBase;
    private String entityName = "facturaciones";

    public FacturacionController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
