package com.example.raiffaisen.DTO;

/*
    Pasul 1: Crearea unui DTO pentru Credențiale
    Primul pas este să definim un Data Transfer Object (DTO)
    pentru a trimite credențialele de autentificare la endpoint.
 */
public class LoginDTO {
    private String email;
    private String password;

    public LoginDTO() {}

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}