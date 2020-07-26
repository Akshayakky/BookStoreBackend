package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.service.IMailService;
import com.bridgelabz.bookstore.service.MyUserDetailsService;
import com.bridgelabz.bookstore.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
    JwtUtil jwtUtil;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtTokenUtil;

    /**
     * @param userDto - User data to send mail
     * @return Send mail to user on successful registration
     * @throws MessagingException
     */
    @PostMapping("/register")
    public String sendRegisterMail(@RequestBody UserDto userDto) throws MessagingException {
        mailService.sendRegisterMail(userDto);
        return "Mail Sent";
    }

    /**
     * @param email - User email to send reset password link
     * @return jwt
     * @throws Exception
     */
    @PostMapping("/forget-password")
    public ResponseEntity<?> sendResetPasswordMail(@RequestParam(value = "email") String email) throws Exception {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        ResponseEntity entity = ResponseEntity.ok(jwtTokenUtil.generateToken(userDetails));
        mailService.sendForgetPasswordMail(email, jwtTokenUtil.generateToken(userDetails));
        return entity;
    }

    /**
     * @param authenticate - JWT Token
     * @param cartDtos     - Ordered book details
     * @return Send mail to the user on successful order with order details
     * @throws Exception
     */
    @PostMapping("/order-confirm")
    public ResponseEntity<?> sendOrderDetailMail(@RequestHeader("Authorization") String authenticate, @RequestBody List<CartDto> cartDtos) throws Exception {
        mailService.sendOrderDetailMail(cartDtos, jwtUtil.extractUsername(authenticate.substring(7)));
        return new ResponseEntity("Mail Sent", HttpStatus.OK);
    }
}