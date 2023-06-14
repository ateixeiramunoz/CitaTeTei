//package com.eoi.CitaTe.controllers;
//
//import com.eoi.CitaTe.entities.Email;
//import com.eoi.CitaTe.services.EmailService;
//import com.eoi.CitaTe.services.MenuService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class SendEmailController {
//
//    EmailService service;
//    @Autowired
//    private JavaMailSender sender;
//    protected AppSendMailController(MenuService menuService, EmailService service) {
//        super(menuService);
//        this.service = service;
//    }
//
//    @GetMapping("/email/emailsimpleusr")
//    public String getSendMailUsr(Model interfazConPantalla){
//        Email email = new Email();
//        String resultadoenvio = "";
//        interfazConPantalla.addAttribute("email", email);
//        interfazConPantalla.addAttribute("resultado", resultadoenvio);
//        return "email/emailsimpleusr";
//    }
//
//    @PostMapping("/email/emailsimpleusr")
//    public String postSendMailUsr(@ModelAttribute(name ="email") Email email, Model interfazConPantalla) {
//        String resultadoenvio = "";
//        System.out.println("emailsimple en el post; " + email.getContent());
//        try {
//            service.sendMail(email);
//            System.out.println("emailsimple enviado");
//            resultadoenvio = "Envío correcto";
//        } catch (Exception e){
//            System.out.println("emailsimple error envío");
//            resultadoenvio = "Error envío:" + e;
//        }
//        interfazConPantalla.addAttribute("resultado", resultadoenvio);
//        interfazConPantalla.addAttribute("email", email);
//        return "email/emailsimple";
//    }
//
//}
