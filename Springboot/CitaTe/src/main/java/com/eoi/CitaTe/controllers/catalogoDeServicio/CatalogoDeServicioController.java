package com.eoi.CitaTe.controllers.catalogoDeServicio;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.CatalogoDeServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.catalogoDeServicio}")
public class CatalogoDeServicioController extends MiControladorGenerico<CatalogoDeServicio> {
    @Value("${url.catalogoDeServicio}")
    private String urlBase;
    private String entityName = "catalogoDeServicios";

    public CatalogoDeServicioController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
