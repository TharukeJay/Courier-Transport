package com.rml.courier.repository.model;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import com.rml.courier.repository.PersistObject.PersistObject;

@Getter
@Setter
public class User extends PersistObject {
//    @Indexed(unique = true, name = "username.index", background = true)
    @NonNull
    private String username;

//    @Indexed(unique = true, name = "email.index", background = true)
    @NonNull
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private String organization;
    private UserRole userRole;
    private UserStatus userStatus;

    public enum UserRole {
        SUPER_ADMIN,
        ADMIN,
        DATA_ENTRY_USER
    }

    public enum UserStatus {
        PENDING,
        APPROVED,
        BLOCKED
    }
}
