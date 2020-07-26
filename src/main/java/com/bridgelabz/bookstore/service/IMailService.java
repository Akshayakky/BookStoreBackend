package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.dto.UserDto;

import javax.mail.MessagingException;
import java.util.List;

public interface IMailService {

    void sendRegisterMail(UserDto userDto) throws MessagingException;

    void sendForgetPasswordMail(String email, String jwt) throws MessagingException;

    void sendOrderDetailMail(List<CartDto> cartDtos, String userEmail) throws MessagingException;
}