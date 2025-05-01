package com.mamydinyah.backend.service;

import com.mamydinyah.backend.entity.Email;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    /*public void sendEmail(Email email) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        javaMailSender.send(message);
    }*/

    public void sendEmail(Email email) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody());

        if (email.getFile() != null && !email.getFile().isEmpty()) {
            helper.addAttachment(
                    email.getFile().getOriginalFilename(),
                    email.getFile()
            );
        }

        javaMailSender.send(message);
    }
}
