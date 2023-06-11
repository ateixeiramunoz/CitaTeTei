package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.dto.FacturacionDTO;
import com.eoi.CitaTe.dto.PagoDTO;
import com.eoi.CitaTe.entities.Facturacion;
import com.eoi.CitaTe.entities.Pago;
import com.eoi.CitaTe.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.CitaTe.services.FacturacionMapperService;
import com.eoi.CitaTe.services.PagoMapperService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


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
        super.entityName = entityName;
        super.url = url;
    }


}
