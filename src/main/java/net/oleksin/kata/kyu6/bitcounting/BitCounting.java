package net.oleksin.kata.kyu6.bitcounting;

public class BitCounting {
	public static int countBits(int n){
    int counts = 0;
    while (n > 0) {
      if (n % 2 == 1) {
        counts++;
      }
      n /= 2;
    }
    return counts;
  }
}