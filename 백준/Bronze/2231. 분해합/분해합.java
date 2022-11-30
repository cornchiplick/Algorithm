import java.lang.Math;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String N = in.nextLine();

    int X = Integer.parseInt(N);
    int Y = -1;

    loop:for (int i = 0; i < X; i++) {
      int K = 0;
      for (int j = 0; j < (Integer.toString(i)).length(); j++) {
        K += (int) (Integer.toString(i).charAt(j)) - '0';
        Y = i + K;
      }
      if (Y == X) {
        System.out.println(i);
        break loop;
      } else if (i == X - 1) {
        System.out.println("0");
      }
    }
  }
}
