package net.oleksin.kata.kyu6.romannumeralsencoder;

public class RomanNumeralsEncoder {
    private static final int[] decimals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < decimals.length; i++) {
            while (n >= decimals[i]) {
                stringBuilder.append(roman[i]);
                n -= decimals[i];
            }
        }
        return stringBuilder.toString();
    }
}
