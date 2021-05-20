package ru.itsinfo.securityjwt.auth;

import lombok.Data;

@Data
public class UsernameAndPasswordRequest {

    private String username;
    private String password;
}
