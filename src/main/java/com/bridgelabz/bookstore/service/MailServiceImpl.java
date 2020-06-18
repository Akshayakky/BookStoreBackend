package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.NewUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendRegisterMail(NewUserData newUserData) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Thank you for registering");
        helper.setTo(newUserData.getEmail());
        helper.setText("Dear " + newUserData.getName() + ",\n" +
                "\n" +
                "Thank you for your registration. If you have any questions, please let me know!.\n" +
                "\n" +
                "Thank you , Have great day,", false);
        javaMailSender.send(message);

    }

    @Override
    public void sendForgetPasswordMail(NewUserData newUserData, String jwt) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Reset Password Link");
        helper.setTo(newUserData.getEmail());
        helper.setText("Dear " + newUserData.getName() + ",\n" +
                "Click on the below link to reset Your password.\n" +
                "http://localhost:3000/reset-password/" + jwt + "\n" +
                "Regards ,\n" +
                "The Bookstore Team", false);
        javaMailSender.send(message);
    }
}
