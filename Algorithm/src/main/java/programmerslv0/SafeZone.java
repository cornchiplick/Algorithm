package programmerslv0;

public class SafeZone {

  public static void main(String[] args) {

    int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
    int result = 16;
    System.out.println(solution(board));

  }

  public static int solution(int[][] board) {
    int n = board.length;

    int starti;
    int endi;
    int startj;
    int endj;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != 1) {
          // i 검사 시작 위치 설정
          if (i == 0) {
            starti = 0;
          } else {
            starti = i - 1;
          }

          // i 검사 끝 위치 설정
          if (i == n - 1) {
            endi = n - 1;
          } else {
            endi = i + 1;
          }

          // j 검사 시작 위치 설정
          if (j == 0) {
            startj = 0;
          } else {
            startj = j - 1;
          }

          // j 검사 끝 위치 설정
          if (j == n - 1) {
            endj = n - 1;
          } else {
            endj = j + 1;
          }

          loop:
          for (int inspecti = starti; inspecti <= endi; inspecti++) {
            for (int inspectj = startj; inspectj <= endj; inspectj++) {
              if (board[inspecti][inspectj] == 1) {
                board[i][j] = 2;
                break loop;
              }
            }
          }
        }
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != 0) {
          count++;
        }
      }
    }

    return n*n - count;
  }
}
