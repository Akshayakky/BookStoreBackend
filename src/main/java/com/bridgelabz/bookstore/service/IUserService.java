package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.model.User;

import java.util.Optional;

public interface IUserService {
    User registerUser(UserDto userDto) throws UserException;

    Optional<User> getUserByEmail(String email);

    User updateUser(UserDto userDto, String email);
}
