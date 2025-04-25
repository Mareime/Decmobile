package com.example.backendrecette.jwtModule.Dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String email;

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
}