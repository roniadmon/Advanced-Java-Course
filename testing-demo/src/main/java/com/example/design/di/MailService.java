package com.example.design.di;

public class MailService {
    public void notify(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("AHHHHHHHAAA! as well");
        }
        System.out.println("notifying user: '" + email + "'");
    }
}
