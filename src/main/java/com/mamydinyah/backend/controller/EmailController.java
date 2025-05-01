package com.mamydinyah.backend.controller;

import com.mamydinyah.backend.entity.Email;
import com.mamydinyah.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String start() {
        return "email";
    }

    /*@PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody Email email){
        try {
            emailService.sendEmail(email);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
        }
    }*/

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        Email email = new Email();
        email.setTo(to);
        email.setSubject(subject);
        email.setBody(body);
        email.setFile(file);

        try {
            emailService.sendEmail(email);
            return ResponseEntity.ok("Email avec pièce jointe envoyé !");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur : " + e.getMessage());
        }
    }
}
