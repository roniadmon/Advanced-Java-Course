package com.example.design.srp;

public class Bank {
    public void transfer(String id, Double amount) {
        if (id.length() < 5 || id.length() > 10) {
            throw new IllegalArgumentException("AHHHHHHHAAA!");
        }
        System.out.println("Moving amount: '" + amount + "'");
    }
}
