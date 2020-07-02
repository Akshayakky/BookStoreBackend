package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.service.IUserService;
import com.bridgelabz.bookstore.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    JwtUtil jwtUtil;

    /**
     * @param userDto - New User Details
     * @return Register new user
     */
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            User user = userService.registerUser(userDto);
        } catch (UserException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @param email - Email to get user details
     * @return User details
     */
    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam(value = "email") String email) {
        try {
            return new ResponseEntity<>(userService.getUserByEmail(email).get(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @param userDto - Updated user details
     * @param id      - Id to update user details
     * @return Updated user details
     * @throws UserException
     */
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto, @RequestHeader("Authorization") String authenticate)
            throws UserException {
        return new ResponseEntity<>(userService.updateUser(userDto, jwtUtil.extractUsername(authenticate.substring(7))), HttpStatus.OK);
    }
}
