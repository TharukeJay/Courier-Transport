package com.rml.courier.service.Impl;

import com.rml.courier.repository.model.User;
import com.rml.courier.repository.UserRepository;
import com.rml.courier.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveRegistration(User user) {
        log.info("[User Service] ==> Requesting user registration");
        if (userRepository.existsByUsername(user.getUsername())) {
            return null;
        } else {
            if (user.getUserRole() == User.UserRole.ADMIN || user.getUserRole() == User.UserRole.SUPER_ADMIN) {
                user.setUserStatus(User.UserStatus.PENDING);
            } else {
                user.setUserStatus(User.UserStatus.APPROVED);
            }
            User savedUser = userRepository.save(user);
            log.info("[User Service] ==> User saved successfully [{}]", user);
            return savedUser;
        }
    }

    @Override
    public Boolean checkUserByEmail(String email) {
        log.info("[User Service] ==> User checking user availability for email [{}]", email);
        if (userRepository.existsByEmail(email)) {
            log.info("[User Service] ==> User available for email [{}]", email);
            return true;
        } else {
            log.info("[User Service] ==> User not available for email [{}]", email);
            return false;
        }
    }

    @Override
    public boolean validateUniqueUser(String userName) {
        log.info("[User Service] ==> Requesting username validation for name [{}]", userName);
        return userRepository.existsUserByUsername(userName);
    }

    @Override
    public boolean validateUniqueEmail(String email) {
        log.info("[User Service] ==> Requesting email validation for email [{}]", email);
        return userRepository.existsUserByEmail(email);
    }
}
