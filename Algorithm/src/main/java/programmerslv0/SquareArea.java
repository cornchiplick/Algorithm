package programmerslv0;

import java.util.Arrays;

public class SquareArea {

  public static void main(String[] args) {

    int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
    int result = 1;
    System.out.println(solution(dots));

  }

  public static int solution(int[][] dots) {
    int answer = 0;

    int[] x = {dots[0][0], dots[1][0], dots[2][0], dots[3][0]};
    int[] y = {dots[0][1], dots[1][1], dots[2][1], dots[3][1]};
    Arrays.sort(x);
    Arrays.sort(y);

    return (x[3] - x[0])*(y[3] - y[0]);
  }
}
