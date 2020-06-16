package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * @param userDto
     * @return Register new user
     */
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        try {
            User user = userService.registerUser(userDto);
        } catch (UserException e) {
            return new ResponseEntity<>("User Already Registered", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User Register Successfully", HttpStatus.CREATED);
    }
}
