package com.example.design.di;

import java.time.ZonedDateTime;

public class SalaryHandler {
    private final SalaryCalculator salaryCalculator;
    private final Bank bank;
    private final MailService mailService;

    public SalaryHandler(SalaryCalculator salaryCalculator, Bank bank, MailService mailService) {
        this.salaryCalculator = salaryCalculator;
        this.bank = bank;
        this.mailService = mailService;
    }

    public void pay(String id, Double total, Double percent, ZonedDateTime dateTime, String email) {
        Double payment = salaryCalculator.calc(total, percent, dateTime);
        bank.transfer(id, payment);
        mailService.notify(email);
    }
}
