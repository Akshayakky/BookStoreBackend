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

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam(value = "email") String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email).get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto, @RequestParam(value = "id") Long id)
            throws UserException {
        return new ResponseEntity<>(userService.updateUser(userDto, id), HttpStatus.OK);
    }
}
