package com.peura.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberBamboozlerTest {

    @Test
    public void testSmallestNumberOfNumbers1() {
        int[] testi1 = {10, 4, 1};
        assertEquals(2, NumberBamboozler.smallestNumberOfNumbers(testi1));
    }

    @Test
    public void testSmallestNumberOfNumbers2() {
        int[] testi2 = {3, 1, 5};
        assertEquals(1, NumberBamboozler.smallestNumberOfNumbers(testi2));
    }

    @Test
    public void testSmallestNumberOfNumbers3() {
        int[] testi3 = {2, 2, 3, 5, 10};
        assertEquals(0, NumberBamboozler.smallestNumberOfNumbers(testi3));
    }

    @Test
    public void testSmallestNumberOfNumbers4() {
        int[] testi4 = {1, 1, 2, 4, 7, 7};
        assertEquals(0, NumberBamboozler.smallestNumberOfNumbers(testi4));
    }
}

