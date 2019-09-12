package com.example.design.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

import static com.example.design.di.SalaryCalculator.BONUS;
import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorTest {

    @ParameterizedTest
    @MethodSource("calcData")
    void calc(double total, double percent, ZonedDateTime dateTime, double expected) {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        assertEquals(
                expected,
                salaryCalculator.calc(total, percent, dateTime)
        );
    }

    private static Stream<Arguments> calcData() {
        return Stream.of(
                Arguments.of(100, 10, getZonedDateTimeOfMonth(11), 10),
                Arguments.of(100, 10, getZonedDateTimeOfMonth(12), BONUS + 10),
                Arguments.of(100, 200, getZonedDateTimeOfMonth(11), 100),
                Arguments.of(100, 200, getZonedDateTimeOfMonth(12), BONUS + 100),
                Arguments.of(100, -100, getZonedDateTimeOfMonth(11), 0),
                Arguments.of(100, -100, getZonedDateTimeOfMonth(12), BONUS)
        );
    }

    private static ZonedDateTime getZonedDateTimeOfMonth(int month) {
        return ZonedDateTime.of(2019, month, 1, 1, 1, 1, 1, ZoneId.of("UTC"));
    }

    @Test
    void test() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertTrue(true)
        );
    }
}
