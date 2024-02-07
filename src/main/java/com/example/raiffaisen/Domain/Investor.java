package com.example.raiffaisen.Domain;

// Investor.java
public class Investor extends Entitate {
    private String investorName;
    private int investorAge;
    private String investorEmail;
    private String investorPassword;
    private float investorMoney;

    public Investor() {
        super(-1);
        this.investorName = null;
        this.investorAge = 0;
        this.investorEmail = null;
        this.investorPassword = null;
        this.investorMoney = 0;
    }

    public String getInvestorName() {
        return investorName;
    }
    public int getInvestorAge() {
        return investorAge;
    }

    public void setInvestorAge(int investorAge) {
        this.investorAge = investorAge;
    }

    public String getInvestorEmail() {
        return investorEmail;
    }

    public void setInvestorEmail(String investorEmail) {
        this.investorEmail = investorEmail;
    }

    public String getInvestorPassword() {
        return investorPassword;
    }

    public void setInvestorPassword(String investorPassword) {
        this.investorPassword = investorPassword;
    }

    public float getInvestorMoney() {
        return investorMoney;
    }

    public void setInvestorMoney(float investorMoney) {
        this.investorMoney = investorMoney;
    }

    public Investor(int id, String investorName, int investorAge, String investorEmail , String investorPassword, float investorMoney) {
        super(id);
        this.investorName = investorName;
        this.investorAge = investorAge;
        this.investorEmail = investorEmail;
        this.investorPassword = investorPassword;
        this.investorMoney = investorMoney;
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


