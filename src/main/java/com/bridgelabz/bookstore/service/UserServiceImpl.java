package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param userDto
     * @return Register new user for authentication
     * @throws UserException
     */
    @Override
    public User registerUser(UserDto userDto) throws UserException {
        User user = modelMapper.map(userDto, User.class);
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new UserException(UserException.ExceptionType.ALREADY_REGISTERED, "Email Id Already Registered");
        return userRepository.save(user);
    }
}
