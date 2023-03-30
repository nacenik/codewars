package net.oleksin.kata.kyu8.gravityflip;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GravityFlipTest {

    private static int[] flip(char dir, int[] arr) {

        int[] rra = Arrays.copyOf(arr, arr.length);

        Arrays.sort(rra);

        if (dir == 'L') {
            for (int i = 0; i < rra.length / 2; i++) {
                int temp = rra[i];
                rra[i] = rra[rra.length - 1 - i];
                rra[rra.length - 1 - i] = temp;
            }
        }

        return rra;
    }

    private static char getRandomDir()
    {
        Random r = new Random();
        return r.nextInt(2) == 0 ? 'R' : 'L';
    }

    private static int[] getRandomArr()
    {
        Random r = new Random();
        int size = r.nextInt(50);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = r.nextInt(50);
        }
        return arr;
    }

    @Test
    public void Fixed() {
        assertArrayEquals(new int[]{ 1,4,5,6,7 }, GravityFlip.flip('R', new int[]{ 4,5,6,7,1 }));
        assertArrayEquals(new int[]{ 9,8,3,2,1,0 }, GravityFlip.flip('L', new int[]{ 3,0,9,8,1,2 }));
        assertArrayEquals(new int[]{ 12,1,0,0,0 }, GravityFlip.flip('L', new int[]{ 0,0,12,0,1 }));
        assertArrayEquals(new int[]{ 2,4,7,13,93 }, GravityFlip.flip('R', new int[]{ 13,2,4,7,93 }));
        assertArrayEquals(new int[]{ 1,2,3,4,5 }, GravityFlip.flip('R', new int[]{ 5,4,3,2,1 }));
    }

    @Test
    public void Random()
    {
        for (int i = 0; i < 100; i++)
        {
            char dir = getRandomDir();
            int[] arr = getRandomArr();

            assertArrayEquals(flip(dir, arr), GravityFlip.flip(dir, arr));
        }
    }
    @Test
    public void Sample() {
        assertArrayEquals(new int[]{ 1,2,2,3 }, GravityFlip.flip('R', new int[]{ 3,2,1,2 }));
        assertArrayEquals(new int[]{ 5,5,4,3,1 }, GravityFlip.flip('L', new int[]{ 1,4,5,3,5 }));
    }
}