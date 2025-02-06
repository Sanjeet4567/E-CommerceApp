package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.config.JWTProvider;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService{
    private UserRepository userRepository;
    private JWTProvider jwtProvider;
    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent())return user.get();
        throw new UserException("User not found with id:"+userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email=jwtProvider.getEmailFromToken(jwt);
        User user=userRepository.findByEmail(email);
        if(user!=null)return user;
        throw new UserException("User not found with email"+email);
    }
}
