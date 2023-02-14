package curriculum.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 1012
 * 실버II - 유기농 배추
 * 전략
 * 1) dfs 탐색법 이용
 * 2) 동서남북 한칸씩 점차 넓혀나가는 재귀함수를 만드는 것이 중요하다.
 */
public class OrganicCabbage_1012 {
  private static int width;
  private static int height;
  private static int k;
  private static boolean[][] arr;
  private static boolean[][] check;
  // 동서남북 한칸씩 가기
  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    // 각 테스트
    for (int testCase = 0; testCase < t; testCase++) {
      // 변수 초기화
      StringTokenizer st = new StringTokenizer(br.readLine());
      width = Integer.parseInt(st.nextToken());
      height = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      arr = new boolean[width][height];
      check = new boolean[width][height];
      int count = 0;

      // 배추 위치 표기
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int tempA = Integer.parseInt(st.nextToken());
        int tempB = Integer.parseInt(st.nextToken());
        arr[tempA][tempB] = true;
      }

      // 배추군 탐색
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (arr[i][j] && !check[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }
      System.out.println(count);
    }
    br.close();
  }

  private static void dfs(int i, int j) {
    check[i][j] = true;

    for (int idx = 0; idx < 4; idx++) {
      int x = i + dx[idx];
      int y = j + dy[idx];

      if (x >= 0 && y >= 0 && x < width && y < height) {
        if (!check[x][y] && arr[x][y]) {
          dfs(x, y);
        }
      }
    }
  }
}
