package com.EOI.Citate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping(value = {"/",""})
    public String showMainPage() {

        return "index";
    }

    @GetMapping(value = {"/usuarios"})
    public String showUsuariosPage() {

        return "usuarios";
    }

}
