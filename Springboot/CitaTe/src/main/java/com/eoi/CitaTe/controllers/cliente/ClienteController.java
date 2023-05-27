package com.eoi.CitaTe.controllers.cliente;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Cliente;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.cliente}")
public class ClienteController extends MiControladorGenerico<Cliente> {
    @Value("${url.cliente}")
    private String urlBase;
    private String entityName = "clientes";

    public ClienteController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}