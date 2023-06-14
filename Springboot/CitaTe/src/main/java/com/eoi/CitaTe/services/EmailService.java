package com.eoi.CitaTe.services;

import com.eoi.CitaTe.entities.Email;
import jakarta.mail.*;
import freemarker.template.Configuration;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;


@Service
@RequiredArgsConstructor
public class EmailService {

    private Session session;
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration fmConfiguration;


    // MAILTRAP es un servicio que simula un servidor de correo
    // y permite probar y depurar el envío de correos electrónicos
    // sin enviar correos electrónicos reales a los destinatarios.

    public void initSesion() {
        //provide Mailtrap's username
        final String username = "api";
        //provide Mailtrap's password
        final String password = "dd05f45be13af56332d53dec9b2ab3d2";
        //provide Mailtrap's host address
        String host = "live.smtp.mailtrap.io";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "8080");
        //create the Session object
        session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }


    public void sendMail(Email mail) {

        initSesion();
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(mail.getFrom()));
            //set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
            //set email subject field
            message.setSubject(mail.getSubject());
            //set the content of the email message
            message.setText(mail.getContent());
            //send the email message
            System.out.println("sendMail antes de Transport; " + mail.getContent());
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // sendAPIMail en la clase EmailService se encarga de enviar un correo electrónico
        // utilizando una API en lugar del protocolo SMTP estándar.


//        public void sendAPIMail(Email mail) throws IOException {
//            OkHttpClient client = new OkHttpClient().newBuilder()
//                    .build();
//            MediaType mediaType = MediaType.parse("application/json");
//            //Creamos el json para el email
//            JSONObject jsonObject = new JSONObject();
//            String jsontext = "{\"from\":{\"email\":\"" + mail.getFrom()+ "\"," +
//                    "\"name\":\"Gestion turnos\"},\"to\":[{\"email\":\""+ mail.getTo() +
//                    "\"}],\"subject\":\""+ mail.getSubject()+ "\"," +
//                    "\"text\":\""+ mail.getContent()+"\",\"category\":\"Integration Test\"}";
//            System.out.println(jsontext);
//
//            RequestBody body = RequestBody.create(mediaType, jsontext);
//            Request request = new Request.Builder()
//                    .url("https://send.api.mailtrap.io/api/send")
//                    .method("POST", body)
//                    .addHeader("Authorization", "Bearer b411b9132ea86b8cb2cbada15bfcbfd1")
//                    .addHeader("Content-Type", "application/json")
//                    .build();
//            Response response = client.newCall(request).execute();
//            System.out.println("Respuesta tras el envio:" + response );
//            //Controlar el objeto response
//            if (response.isSuccessful() == false ){
//                Exception e = new Exception(response.message());
//                throw new RuntimeException(e);
//            }
//
//        }

    }
}


