package com.peura.numbers;
import java.util.Arrays;

public class NumberBamboozler {

  public static int smallestNumberOfNumbers(int[] numbers) {
    Arrays.sort(numbers);

    int count = Integer.MAX_VALUE;

    for(int i = 0; i < numbers.length - 1; i++) {
      int diff = numbers[i + 1] - numbers[i] - 1;
      if (diff < count) {
        count = diff;
      }
    }

    return Math.max(count, 0); // ettei mene negatiiviseksi, muuten olisi vaan "return count;"
  }
}
