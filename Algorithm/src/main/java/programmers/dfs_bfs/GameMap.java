package programmers.dfs_bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 깊이/너비 우선 탐색(DFS/BFS)
 * lv2 - 게임 맵 최단거리
 * 전략
 * 1) 한번 갔던 길은 가지 않는다.
 * 2) 목표에 도달하지 못했다면 -1을 return한다.
 * 3) 목표지점인 [n-1][m-1]지점에 도달했다면 그 때까지 이동한 거리(cost)를 return한다.
 */
public class GameMap {
  private static int[] dx = {-1, 0, 1, 0};
  private static int[] dy = {0, -1, 0, 1};
  private static boolean[][] visited;
  private static int n;
  private static int m;

  public static void main(String[] args) {
    int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    int result1 = 11;
    System.out.println(solution(maps1));

    int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
    int result2 = -1;
    System.out.println(solution(maps2));
  }

  public static int solution(int[][] maps) {
    n = maps.length;
    m = maps[0].length;
    visited = new boolean[n][m];

    return bfs(0, 0, maps);
  }

  private static int bfs(int x, int y, int[][] maps) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, 1));
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();
      if (node.x == n - 1 && node.y == m - 1) {
        return node.cost;
      }

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (maps[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny, node.cost + 1));
          }
        }
      }
    }

    return -1;
  }

  public static class Node {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }
  }
}

