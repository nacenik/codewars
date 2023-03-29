package net.oleksin.kata.kyu6.findtheuniquenumber;

import java.util.Arrays;

public class FindTheUniqueNumber {
    public static double findUnique(double arr[]) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }
}
