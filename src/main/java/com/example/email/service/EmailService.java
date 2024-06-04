package com.example.email.service;

import com.example.email.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
@Slf4j
public class EmailService {

    public void sendEmail(Email email) throws MessagingException {
        try {
            JavaMailSender mailSender = getJavaMailSender();
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

            mimeMessageHelper.setFrom(email.getFrom());
            mimeMessageHelper.setTo(email.getTo());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getContent());

            mailSender.send(message);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mailhog");
        mailSender.setPort(Integer.parseInt("1025"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", false);
        props.put("mail.smtp.starttls.enable", false);

        return mailSender;
    }
}
