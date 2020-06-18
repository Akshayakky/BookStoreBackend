package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.model.NewUserData;

import javax.mail.MessagingException;

public interface IMailService {

    void sendRegisterMail(NewUserData newUserData) throws MessagingException;

    void sendForgetPasswordMail(NewUserData newUserData, String jwt) throws MessagingException;

}
