package com.example.lektion4.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomUser {

    @Size(min = 3, max = 255, message = "Username must be 3-255 chars")
    @NotBlank(message = "Username must not be blank")
    private String username;

    @Size(min = 7, max = 255, message ="Password must be 7-255 chars")
    @NotBlank(message = "Password must not be blank")
    private String password;







    // Boilerplate code
    public CustomUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
