package com.example.backendrecette.jwtModule.Dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // public Object getPassword() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // }
}
