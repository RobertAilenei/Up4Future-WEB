package com.example.raiffaisen.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Investor.java
@Entity
public class Investor extends Entitate {
    private String investorName;
    private int investorAge;
    private String investorEmail;
    private String investorPassword;
    private float investorMoney;

    /*
        * Exista deja un contructor implicit (fara parametrii) in Java, astfel, nu mai e nevoie sa declaram noi unul nou.

        * Sa incercam, ca metodele care nu sunt folosite, sa nu le avem ca si bucati de cod implementate, pentru ca ocupa spatiu si
          pot duce la confuzii in cod (exemplu: SETT-ERI care sunt utilizati, sau IMPORT-URI).
     */

    public Investor(int id) {
        super(id);
    }

    public Investor(int id, String investorName, int investorAge, String investorEmail , String investorPassword, float investorMoney) {
        super(id);
        this.investorName = investorName;
        this.investorAge = investorAge;
        this.investorEmail = investorEmail;
        this.investorPassword = investorPassword;
        this.investorMoney = investorMoney;
    }

    public Investor() {}

    public String getInvestorName() {
        return investorName;
    }
    public int getInvestorAge() {
        return investorAge;
    }

    public String getInvestorEmail() {
        return investorEmail;
    }

    public String getInvestorPassword() {
        return investorPassword;
    }

    public float getInvestorMoney() {
        return investorMoney;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorName='" + investorName + '\'' +
                ", investorAge=" + investorAge +
                ", investorEmail='" + investorEmail + '\'' +
                ", investorPassword='" + investorPassword + '\'' +
                ", investorMoney=" + investorMoney +
                '}';
    }
}


