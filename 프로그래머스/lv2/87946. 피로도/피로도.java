import java.util.*;
class Solution {
  // dfs를 위한 전역변수 설정
  public static boolean[] visited;
  public static int answer = 0;
    
  public int solution(int k, int[][] dungeons) {
    // 방문한 dungeons의 노드를 체크하는 배열
    visited = new boolean[dungeons.length];
    // 최대 방문 던전 수 체크
    int depth = 0;
    dfs(depth, k, dungeons);

    return answer;
  }
    
  private void dfs(int depth, int k, int[][] dungeons) {
    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && dungeons[i][0] <= k) {
        // i번째 던전을 방문했다고 한 후,
        visited[i] = true;

        // i번째 던전을 돌고 나서 가능한 경우 모두 체크
        dfs(depth + 1, k - dungeons[i][1], dungeons);

        // i번째 던전을 돌기 전 상황으로 돌려두기
        visited[i] = false;
      }
    }

    // 최대 방문 경우의 수를 계속 전역변수인 answer에 저장하기
    answer = Math.max(answer, depth);
  }
}