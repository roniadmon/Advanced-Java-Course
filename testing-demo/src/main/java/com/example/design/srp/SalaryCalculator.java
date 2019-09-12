package com.example.design.srp;

import java.time.Month;
import java.time.ZonedDateTime;

public class SalaryCalculator {
    public Double calc(Double total, Double percent, ZonedDateTime dateTime) {
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

        return sum;
    }
}
