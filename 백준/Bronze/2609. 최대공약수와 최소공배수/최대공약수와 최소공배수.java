import java.lang.Math;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int m = in.nextInt();
    int[] max_n = new int[n];
    int[] max_m = new int[m];
    int max = -1;

    for (int i = 0; i <= n - 1; i++) {
      if (n % (i + 1) == 0) {
        max_n[i] = i + 1;
      }
    }

    for (int i = 0; i <= m - 1; i++) {
      if (m % (i + 1) == 0) {
        max_m[i] = i + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ((max_n[i] == max_m[j]) && (max < max_n[i])) {
          max = max_n[i];
        }
      }
    }
    System.out.println(max);

    for (int i = 1; i <= n * m; i++) {
      if ((i % n == 0) && (i % m == 0)) {
        System.out.println(i);
        break;
      }
    }
  }
}
