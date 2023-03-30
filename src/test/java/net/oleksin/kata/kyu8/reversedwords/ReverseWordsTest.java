package net.oleksin.kata.kyu8.reversedwords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {
    @Test
    void sampleTests() {
        assertEquals("world! hello", ReverseWords.reverseWords("hello world!"));
        assertEquals("this like speak doesn't yoda", ReverseWords.reverseWords("yoda doesn't speak like this"));
        assertEquals("foobar", ReverseWords.reverseWords("foobar"));
        assertEquals("editor kata", ReverseWords.reverseWords("kata editor"));
        assertEquals("boat your row row row", ReverseWords.reverseWords("row row row your boat"));
        assertEquals("", ReverseWords.reverseWords(""));
    }
}