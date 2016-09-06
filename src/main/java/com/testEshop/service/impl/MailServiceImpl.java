package com.testEshop.service.impl;

import com.testEshop.model.entity.Client;
import com.testEshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

/**
 * Created by vastl271nko on 02.09.16.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmail(Object object) {
        Client client = (Client) object;

        MimeMessagePreparator preparator = getMessagePreparator(client);

        try {
            mailSender.send(preparator);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final  Client client) {
        MimeMessagePreparator preparator = (mimeMessage) -> {
            mimeMessage.setFrom("pinguinnn007@gmail.com");
            mimeMessage.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(client.getEmail()));
            mimeMessage.setText("Dear " + client.getFirstName() + " " + client.getLastName()
                    + ", thank you for registration. We are glad to see you on our site. \n Your login: "
                    + client.getSsoId() + ".");
            mimeMessage.setSubject("Notification for registration on site. ");
        };
        return preparator;
    }
}
