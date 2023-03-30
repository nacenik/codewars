package net.oleksin.kata.kyu6.countingduplicates;

import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Set<Character> chars = new HashSet<>();
        text = text.toLowerCase();
        for(int i = 0; i < text.length() - 1; i++) {
            char ch = text.charAt(i);
            if (text.indexOf(ch, i + 1) != -1) {
                chars.add(ch);
            }
        }
        return chars.size();
    }
}
