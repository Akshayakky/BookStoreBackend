package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.NewUserData;

import javax.mail.MessagingException;

public interface IMailService {

    void sendMail(NewUserData newUserData) throws MessagingException;
}
