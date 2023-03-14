package com.healthycoderapp;

import org.junit.Test;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    @Test
    public void should_returnTrue_whenDiestisRecommended() {
        // Given
        double height = 1.76;
        double weight = 82;

        // when checked for recommendation
        boolean recommendation = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommendation);
    }


    @Test
    public void should_returnFalse_whenDiestisNotRecommended() {
        // Given
        double height = 1.76;
        double weight = 50;

        // when checked for recommendation
        boolean recommendation = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommendation);
    }

@Test
    public void should_throwException_whenHeightisZero() {
        // Given
        double height = 0.0;
        double weight = 50;
          assertThrows(ArithmeticException.class, () -> {
                 BMICalculator.isDietRecommended(weight,height);

        });


    }

    @Test
    public void findCoderWithWorstBMI() {
        List<Coder> coderList = new ArrayList<>();
        Coder coder1 = new Coder(1.76,82);
        Coder coder2 = new Coder(1.76,70);
        Coder coder3 = new Coder(1.5,70);
        coderList = Arrays.asList(coder1,coder2,coder3);
        Coder worstCoder =BMICalculator.findCoderWithWorstBMI(coderList);
        assertAll(
                ()->assertEquals(1.5,worstCoder.getHeight()),
                ()->assertEquals(70,worstCoder.getWeight())
        );
    }
}