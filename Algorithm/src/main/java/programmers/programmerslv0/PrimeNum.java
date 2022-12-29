package programmers.programmerslv0;

import java.util.Scanner;

public class PrimeNum {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] num = new int[N];
    int count = 0;

    for (int i = 0; i < N; i++) {
      num[i] = in.nextInt();
    }

    for (int i = 0; i < N; i++) {
      if(isPrime(num[i])) {
       count++;
      }
    }
    System.out.println(count);

  }

  static boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

}
