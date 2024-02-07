package com.example.raiffaisen.Domain;

// Startup.java
public class Startup extends Entitate {
    private String startupName;
    public Startup(int id, String startupName) {
        super(id);
        this.startupName = startupName;
    }

    public String getStartupName() {
        return startupName;
    }
}