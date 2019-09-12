package com.example.design.di;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class SalaryHandlerMockitoTest {

    @Test
    void payWithMocks() {
        SalaryCalculator salaryCalculator = mock(SalaryCalculator.class);
        Bank bank = mock(Bank.class);
        MailService mailService = mock(MailService.class);

        double expectedSalary = 15d;
        when(salaryCalculator.calc(eq(Double.valueOf(1d)), eq(1d), any())).thenReturn(expectedSalary);

        new SalaryHandler(
                salaryCalculator,
                bank,
                mailService
        ).pay(
                "abc",
                1d,
                1d,
                ZonedDateTime.now(),
                "mail"
        );

        verify(salaryCalculator, times(1)).calc(eq(1d), eq(1d), any());
        verify(bank, times(1)).transfer(eq("abc"), eq(expectedSalary));
        verify(mailService, times(1)).notify("mail");

        verifyNoMoreInteractions(
                salaryCalculator,
                bank,
                mailService
        );
    }
}
