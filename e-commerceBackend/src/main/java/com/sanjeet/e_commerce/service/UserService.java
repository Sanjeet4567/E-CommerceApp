package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User findUserById(Long userId)throws UserException;
    public User findUserProfileByJwt(String jwt)throws UserException;
}
