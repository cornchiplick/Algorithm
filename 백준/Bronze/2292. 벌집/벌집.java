import java.lang.Math;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();

    int a = 1;

    for (int i = 0;; i++) {
      a = a + (6 * i);
      if (N <= a) {
        System.out.println(i + 1);
        break;
      }
    }
  }
}
