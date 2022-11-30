import java.lang.Math;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int test = in.nextInt();
    int[] height = new int[test];
    int[] width = new int[test];
    int[] countN = new int[test];

    for (int i = 0; i < test; i++) {
      height[i] = in.nextInt();
      width[i] = in.nextInt();
      countN[i] = in.nextInt();
    }

    for (int i = 0; i < test; i++) {
      int Y = countN[i] % height[i];
      if (Y == 0) {
        Y = height[i];
        int X = countN[i] / height[i];
        if (X < 10) {
          System.out.printf("%d0%d\n", Y, X);
        } else {
          System.out.printf("%d%d\n", Y, X);
        }
      } else {
        int X = countN[i] / height[i] + 1;
        if (X < 10) {
          System.out.printf("%d0%d\n", Y, X);
        } else {
          System.out.printf("%d%d\n", Y, X);
        }
      }
    }
  }
}
