package net.oleksin.kata.kyu7.descendingoprder;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        final var split = String.valueOf(num).split("");
        Arrays.sort(split, Collections.reverseOrder());
        return Integer.parseInt(String.join("", split));
    }
}