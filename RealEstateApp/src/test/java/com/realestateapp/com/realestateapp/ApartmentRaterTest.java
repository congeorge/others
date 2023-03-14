package com.realestateapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Executable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentRaterTest {

    @ParameterizedTest
    @CsvSource(value = {"72.0, 250000.0, 0", "48.0, 350000.0, 1", "30.0, 600000.0, 2"})
    void should_ReturnCorrectRating_When_CorrectApartment(Double area, Double price, int rating) {

        // given
        Apartment apartment = new Apartment(area, new BigDecimal(price));
        int expected = rating;

        // when
        int actual = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void should_ReturnErrorValue_When_IncorrectApartment() {

        // given
        Apartment apartment = new Apartment(0.0, new BigDecimal(350000.0));
        int expected = -1;

        // when
        int actual = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(expected, actual);
    }


    @Test
    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList() {

        // given
        List<Apartment> apartments = new ArrayList<>();

        // when

        // then
        assertThrows(RuntimeException.class, () ->   ApartmentRater.calculateAverageRating(apartments));
    }


    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList() {

        // given
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(72.0, new BigDecimal(250000.0)));
        apartments.add(new Apartment(48.0, new BigDecimal(350000.0)));
        apartments.add(new Apartment(30.0, new BigDecimal(600000.0)));

        double expected = 1.0;

        // when
        double actual = ApartmentRater.calculateAverageRating(apartments);

        // then
        assertEquals(expected, actual);
    }
}