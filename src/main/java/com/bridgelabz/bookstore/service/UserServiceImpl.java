package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDto;
import com.bridgelabz.bookstore.exception.UserException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param userDto - New user details
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

    /**
     * @param email - Get user details by email
     * @return User details
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * @param userDto - Updated user details
     * @param email   - user email
     * @return Updated user details
     */
    @Override
    public User updateUser(UserDto userDto, String email) {
        User user = userRepository.findByEmail(email).get();
        if(userDto.getFirstName() != null)
        user.setFirstName(userDto.getFirstName());
        if(userDto.getLastName() != null)
        user.setLastName(userDto.getLastName());
        if(userDto.getPassword() != null)
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }
}
