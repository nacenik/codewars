package net.oleksin.kata.kyu7.descendingoprder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescendingOrderTest {
    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(1, DescendingOrder.sortDesc(1));
    }

    @Test
    public void test_03() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }

    @Test
    public void test_04() {
        assertEquals(2110, DescendingOrder.sortDesc(1021));
    }

    @Test
    public void test_05() {
        assertEquals(987654321, DescendingOrder.sortDesc(123495678));
    }
}