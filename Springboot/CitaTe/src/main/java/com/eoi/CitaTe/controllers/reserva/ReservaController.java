package com.eoi.CitaTe.controllers.reserva;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;

import com.eoi.CitaTe.entities.Reserva;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.reservaController}")
public class ReservaController extends MiControladorGenerico<Reserva> {
    @Value("${url.reservaController}")
    private String urlBase;
    private String entityName = "reservas";

    public ReservaController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
