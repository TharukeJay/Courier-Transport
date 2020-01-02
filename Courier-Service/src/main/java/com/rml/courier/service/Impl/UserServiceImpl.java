package com.rml.courier.service.Impl;

import com.rml.courier.repository.model.User;
import com.rml.courier.repository.UserRepository;
import com.rml.courier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveRegistration(User user) {
        return null;
    }
}
