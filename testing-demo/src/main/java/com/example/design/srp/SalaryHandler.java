package com.example.design.srp;

import java.time.ZonedDateTime;

public class SalaryHandler {
    private SalaryCalculator salaryCalculator = new SalaryCalculator();
    private Bank bank = new Bank();
    private MailService mailService = new MailService();

    public void pay(String id, Double total, Double percent, ZonedDateTime dateTime, String email) {
        Double payment = salaryCalculator.calc(total, percent, dateTime);
        bank.transfer(id, payment);
        mailService.notify(email);
    }
}
