package curriculum.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessBoardRepaint {

  public static boolean[][] board;
  public static int[][] calculatedArr;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    board = new boolean[N][M];
    calculatedArr = new int[N-7][M-7];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        if (str.charAt(j) == 'W') {
          board[i][j] = true; // W 일 때 true
        } else {
          board[i][j] = false; // B 일 때 false
        }
      }
    }

    for (int i = 0; i < N-7; i++) {
      for (int j = 0; j < M-7; j++) {
        calculate(i, j);
      }
    }

    int min = 64;
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        if (min > calculatedArr[i][j]) {
          min = calculatedArr[i][j];
        }
      }
    }

    System.out.println(min);

  }

  public static void calculate(int starti, int startj) {
    int count = 0;

    boolean tf = board[starti][startj];
    for (int i = starti; i <= starti + 7; i++) {
      for (int j = startj; j <= startj + 7; j++) {
        if (board[i][j] != tf) {
          count++;
        }
        tf = !tf;
      }
      tf = !tf;
    }

    calculatedArr[starti][startj] = Math.min(count, 64 - count);
  }
}
