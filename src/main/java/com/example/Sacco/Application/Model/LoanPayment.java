package com.example.Sacco.Application.Model;

public class LoanPayment {
    private String memberId;
    private double amount;

    // Constructor
    public LoanPayment(String memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Optional: helper method to display info
    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Payment Amount: " + amount);
    }
}