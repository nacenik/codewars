package net.oleksin.kata.kyu7.simplefunarraypacking;

import java.util.stream.IntStream;

public class SimpleFunArrayPacking {
    public static long arrayPacking(int[] arr) {
        return IntStream.range(0, arr.length).mapToLong(i -> (long)arr[i] << (i * 8)).sum();
    }
}
