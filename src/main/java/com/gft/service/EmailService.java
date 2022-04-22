package com.gft.service;

import com.gft.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void enviarEmail(Usuario usuario){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("devjosimar@gmail.com");
            message.setTo(usuario.getEmail());
            message.setSubject("Nova Tentativa de acesso ao Sistema");
            message.setText("Novo acesso registrado \n" + "Usuário: "+usuario.getNome() + "\nE-mail: "+usuario.getEmail()+"\nData do acesso: "+ LocalDate.now().format(formatter));
            emailSender.send(message);
        }catch (MailException e){
            System.out.println("Erro no envio do e-mail: "+e.getMessage());
        }
    }

}
