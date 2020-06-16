package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.model.NewUserData;
import com.bridgelabz.bookstore.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail-sender")
@CrossOrigin
public class MailSenderController {

    @Autowired
    IMailService mailService;

    @PostMapping
    public String sendMail(@RequestBody NewUserData newUserData) throws MessagingException {
        mailService.sendMail(newUserData);
        return "Mail Sent";
    }
}
