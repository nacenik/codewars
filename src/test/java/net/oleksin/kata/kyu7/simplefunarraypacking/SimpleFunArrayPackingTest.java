package net.oleksin.kata.kyu7.simplefunarraypacking;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SimpleFunArrayPackingTest {
    @Test
    public void fixedTests() {
        assertEquals(21784, SimpleFunArrayPacking.arrayPacking(new int[] {24, 85, 0}));
        assertEquals(2567447, SimpleFunArrayPacking.arrayPacking(new int[] {23, 45, 39}));
        assertEquals(257, SimpleFunArrayPacking.arrayPacking(new int[] {1, 1}));
        assertEquals(0, SimpleFunArrayPacking.arrayPacking(new int[] {0}));
        assertEquals(4294967295L, SimpleFunArrayPacking.arrayPacking(new int[] {255, 255, 255, 255}));
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 100; i++) {
            int[] rarray = randomArray();
            long expected = solution(rarray);
            assertEquals(expected, SimpleFunArrayPacking.arrayPacking(rarray));
        }
    }

    private Random random = new Random();

    private int[] randomArray() {
        int length = 1 + random.nextInt(4);
        int[] rarray = new int[length];
        for (int i = 0; i < length; i++) {
            rarray[i] = random.nextInt(256);
        }
        return rarray;
    }

    private long solution(int[] arr) {
        long[] powers = new long[] {1, 256, 65536, 16777216};
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * powers[i];
        }
        return result;
    }
}