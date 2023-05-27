package com.eoi.CitaTe.controllers.metodoPagoMensual;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.entities.MetodoPagoMensual;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.metodoPagoMensualController}")

public class MetodoPagoMensualController extends MiControladorGenerico<MetodoPagoMensual> {
    @Value("${url.metodoPagoMensualController}")
    private String urlBase;
    private String entityName = "metodoPagosMensual";

    public MetodoPagoMensualController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
