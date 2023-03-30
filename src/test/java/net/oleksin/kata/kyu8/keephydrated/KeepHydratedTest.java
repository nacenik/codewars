package net.oleksin.kata.kyu8.keephydrated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeepHydratedTest {
    KeepHydrated kh = new KeepHydrated();
    @Test
    public void basicTest1() {assertEquals(1, kh.Liters(2));}
    @Test
    public void basicTest2()  {assertEquals(0, kh.Liters(0.82));}
    @Test
    public void basicTest3()  {assertEquals(6, kh.Liters(12.83));}
    @Test
    public void basicTest4()  {assertEquals(901, kh.Liters(1802.44));}
    @Test
    public void basicTest5()  {assertEquals(30, kh.Liters(60));}
    @Test
    public void randTesting()  {

        for(int i = 0; i < 5; i++)  {

            double R = Math.random() * 100 + 1; // To 100
            assertEquals(((int)(R / 2)), kh.Liters(R));

            R = Math.random() * 10 + 1; // To 10
            assertEquals(((int)(R / 2)), kh.Liters(R));

        }

    }
    @Test
    public void SampleTest1() {

        assertEquals(1, kh.Liters(2));

    }
    @Test
    public void SampleTest2()  {

        assertEquals(0, kh.Liters(0.97));

    }
    @Test
    public void SampleTest3()  {

        assertEquals(7, kh.Liters(14.64));

    }
    @Test
    public void SampleTest4()  {

        assertEquals(800, kh.Liters(1600.20));

    }
    @Test
    public void SampleTest5()  {

        assertEquals(40, kh.Liters(80));

    }
}