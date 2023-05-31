package com.eoi.CitaTe.controllers;

import com.eoi.CitaTe.abstraccomponents.MiControladorGenerico;
import com.eoi.CitaTe.entities.Menu;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${url.menu}")
public class MenuController extends MiControladorGenerico<Menu> {
    @Value("${url.menu}")
    private String urlBase;
    private String entityName = "menus";

    public MenuController() {
        super();
    }

    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }
}
