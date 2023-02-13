package programmers.applytest;

public class Grid {
  public static void main(String[] args) {
    String[] grid = {".#.", "#..", ".#."};
    System.out.println(solution(grid)); // 3

  }

  public static int solution(String[] grid) {
    // 상 하 좌 우로 향하다가 모두 '#'을 만난다면 이 '.'은 '#'로 치환될 수 있다.
    char[][] cgrid = new char[grid.length][grid[0].length()];

    for (int i = 0; i < grid.length; i++) {
      cgrid[i] = grid[i].toCharArray();
    }

    int sum = 0;
    for (int i = 0; i < cgrid.length; i++) {
      for (int j = 0; j < cgrid[i].length; j++) {
        sum += isWell(cgrid, i, j);
      }
    }

    return sum;
  }

  private static int isWell(char[][] cgrid, int i, int j) {
    return isWellLeft(cgrid, i, j) * isWellRight(cgrid, i, j * isWellUp(cgrid, i, j) * isWellDown(cgrid, i, j));
  }

  private static int isWellLeft(char[][] cgrid, int i, int j) {
    if (j < 0) {
      return 0;
    }

    if (cgrid[i][j] == '#') {
      return 1;
    }

    return isWellLeft(cgrid, i, j - 1);
  }

  private static int isWellRight(char[][] cgrid, int i, int j) {
    if (j >= cgrid[0].length) {
      return 0;
    }

    if (cgrid[i][j] == '#') {
      return 1;
    }

    return isWellRight(cgrid, i, j + 1);
  }

  private static int isWellUp(char[][] cgrid, int i, int j) {
    if (i < 0) {
      return 0;
    }

    if (cgrid[i][j] == '#') {
      return 1;
    }

    return isWellUp(cgrid, i - 1, j);
  }

  private static int isWellDown(char[][] cgrid, int i, int j) {
    if (i >= cgrid.length) {
      return 0;
    }

    if (cgrid[i][j] == '#') {
      return 1;
    }

    return isWellDown(cgrid, i + 1, j);
  }

}
