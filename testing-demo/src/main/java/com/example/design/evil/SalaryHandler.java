package com.example.design.evil;

import java.time.Month;
import java.time.ZonedDateTime;

public class SalaryHandler {
    public void pay(String id, Double total, Double percent, ZonedDateTime dateTime, String email) {
        if (percent > 100) {
            percent = 100d;
        }
        if (percent < 0) {
            percent = 0d;
        }
        double sum = total * percent / 100;
        if (Month.DECEMBER == dateTime.getMonth()) {
            sum += 10000;
        }

        if (id.length() < 5 || id.length() > 10) {
            throw new IllegalArgumentException("AHHHHHHHAAA!");
        }
        System.out.println("Moving amount: '" + sum + "'");

        if (!email.contains("@")) {
            throw new IllegalArgumentException("AHHHHHHHAAA! as well");
        }
        System.out.println("notifying user: '" + email + "'");
    }
}
