package com.eoi.CitaTe.controllers.pago;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Pago;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.pago}")

public class PagoController extends MiControladorGenerico<Pago> {
    @Value("${url.pago}")
    private String urlBase;
    private String entityName = "pagos";

    public PagoController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
