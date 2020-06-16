package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.MyUserDetails;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found : " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
