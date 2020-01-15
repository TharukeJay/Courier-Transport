package com.rml.courier.service;

import com.rml.courier.repository.model.User;

public interface UserService {

    User saveRegistration (User user);

    Boolean checkUserByEmail(String email);

    boolean validateUniqueUser(String userName);

    boolean validateUniqueEmail(String email);
}
