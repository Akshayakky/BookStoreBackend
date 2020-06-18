package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.model.NewUserData;

import javax.mail.MessagingException;
import java.util.List;

public interface IMailService {

    void sendRegisterMail(NewUserData newUserData) throws MessagingException;

    void sendForgetPasswordMail(NewUserData newUserData, String jwt) throws MessagingException;

    void sendOrderDetailMail(List<CartDto> cartDtos, Long userId) throws MessagingException;
}
