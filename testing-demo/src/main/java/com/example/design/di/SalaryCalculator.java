package com.example.design.di;

import java.time.Month;
import java.time.ZonedDateTime;

public class SalaryCalculator {

    public static final int BONUS = 10000;

    public Double calc(Double total, Double percent, ZonedDateTime dateTime) {
        if (percent > 100) {
            percent = 100d;
        }
        if (percent < 0) {
            percent = 0d;
        }
        double sum = total * percent / 100;
        if (Month.DECEMBER == dateTime.getMonth()) {
            sum += BONUS;
        }

        return sum;
    }
}
