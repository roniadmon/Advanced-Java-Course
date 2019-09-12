package com.example.design.di;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

class SalaryHandlerTest {

    @Test
    void pay() {
        new SalaryHandler(
                new SalaryCalculator() {
                    @Override
                    public Double calc(Double total, Double percent, ZonedDateTime dateTime) {
                        System.out.println("Calc:");
                        System.out.println("total = " + total + ", percent = " + percent + ", dateTime = " + dateTime);
                        System.out.println();
                        return 1d;
                    }
                },
                new Bank() {
                    @Override
                    public void transfer(String id, Double amount) {
                        System.out.println("Bank:");
                        System.out.println("id = " + id + ", amount = " + amount);
                        System.out.println();
                    }
                },
                new MailService() {
                    @Override
                    public void notify(String email) {
                        System.out.println("Mail:");
                        System.out.println("email = " + email);
                        System.out.println();
                    }
                }
        ).pay(
                "abc",
                1d,
                1d,
                ZonedDateTime.now(),
                "mail"
        );
    }
}
