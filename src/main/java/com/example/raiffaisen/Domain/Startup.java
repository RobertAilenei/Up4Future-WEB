package com.example.raiffaisen.Domain;

// Startup.java
public class Startup extends Entitate {
    private final String startupName;
    private final String startupEmail;
    private final String startupPassword;
    public Startup(int id, String startupName, String startupEmail, String startupPassword) {
        super(id);
        this.startupName = startupName;
        this.startupEmail = startupEmail;
        this.startupPassword = startupPassword;
    }

    public String getStartupName() {
        return startupName;
    }

    public String getStartupEmail(){
        return startupEmail;
    }

    public String getStartupPassword() {
        return startupPassword;
    }

    @Override
    public String toString() {
        return "Startup{" +
                "startupName='" + startupName + '\'' +
                ", startupEmail='" + startupEmail + '\'' +
                ", startupPassword='" + startupPassword + '\'' +
                '}';
    }
}