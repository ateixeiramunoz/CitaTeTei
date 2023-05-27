package com.eoi.CitaTe.controllers.empresa;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Empresa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.empresa}")
public class EmpresaController extends MiControladorGenerico<Empresa> {
    @Value("${url.empresa}")
    private String urlBase;
    private String entityName = "empresas";

    public EmpresaController(){
        super();
    }

    @PostConstruct
    private void init(){
        super.entityName = urlBase;
        super.entityPrefix = entityName + "/";
    }
}
