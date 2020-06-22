package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.model.AuthenticationRequest;
import com.bridgelabz.bookstore.model.AuthenticationResponse;
import com.bridgelabz.bookstore.model.NewUserData;
import com.bridgelabz.bookstore.service.IMailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/mail-sender")
@CrossOrigin
public class MailSenderController {

    @Autowired
    IMailService mailService;

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    ModelMapper modelMapper;

    /**
     * @param newUserData - User data to send mail
     * @return Send mail to user on successful registration
     * @throws MessagingException
     */
    @PostMapping("/register")
    public String sendRegisterMail(@RequestBody NewUserData newUserData) throws MessagingException {
        mailService.sendRegisterMail(newUserData);
        return "Mail Sent";
    }

    /**
     * @param newUserData - User data to send reset password link
     * @throws Exception
     */
    @PostMapping("/forget-password")
    public ResponseEntity<?> sendResetPasswordMail(@RequestBody NewUserData newUserData) throws Exception {
        ResponseEntity entity = authenticationController.createAuthenticationToken(new AuthenticationRequest(newUserData.getEmail(), newUserData.getPassword()));
        AuthenticationResponse response = modelMapper.map(entity.getBody(), AuthenticationResponse.class);
        mailService.sendForgetPasswordMail(newUserData, response.getJwt());
        return entity;
    }

    /**
     * @param userId   - UserId to send order details
     * @param cartDtos - Ordered book details
     * @return Send mail to the user on successful order with order details
     * @throws Exception
     */
    @PostMapping("/order-confirm")
    public ResponseEntity<?> sendOrderDetailMail(@RequestParam(value = "user-id") Long userId, @RequestBody List<CartDto> cartDtos) throws Exception {
        mailService.sendOrderDetailMail(cartDtos, userId);
        return new ResponseEntity("Mail Sent", HttpStatus.OK);
    }
}
