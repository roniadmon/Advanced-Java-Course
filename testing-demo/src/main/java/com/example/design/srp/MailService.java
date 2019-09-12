package com.example.design.srp;

public class MailService {
    private MailService mailService = new MailService();
    private Bank bank = new Bank();

    public void notify(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("AHHHHHHHAAA! as well");
        }
        System.out.println("notifying user: '" + email + "'");
    }
}
