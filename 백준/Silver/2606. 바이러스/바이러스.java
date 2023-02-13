import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 - 2606
 * 실버III - 바이러스
 * 전략
 * 1) 1번 컴퓨터로부터 퍼져나가는 바이러스에 감염된 컴퓨터의 수를 출력한다.
 * 2) 1번부터 시작하여 bfs탐색방법으로 개수를 셀 것이다.
 */
public class Main {

  // 노드들과 간선들을 표기하기 위한 배열
  private static boolean[][] arr;

  // 방문노드를 체크하기 위한 배열
  private static boolean[] flag;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int node = Integer.parseInt(br.readLine());
    int line = Integer.parseInt(br.readLine());

    arr = new boolean[node + 1][node + 1];
    flag = new boolean[node + 1];

    // 간선 표기
    StringTokenizer st;
    int nodeA;
    int nodeB;
    for (int i = 0; i < line; i++) {
      st = new StringTokenizer(br.readLine());
      nodeA = Integer.parseInt(st.nextToken());
      nodeB = Integer.parseInt(st.nextToken());

      // a>b, b>a는 하나의 간선이므로 모두 표기해주어야 한다.
      arr[nodeA][nodeB] = true;
      arr[nodeB][nodeA] = true;
    }

    // bfs 탐색
    int count = bfs(1);

    // 출력
    System.out.println(count);




  }

  private static int bfs(int start) {
    int count = 0;

    // q를 이용한 bfs 탐색
    Queue<Integer> q = new LinkedList<>();
    flag[start] = true;
    q.offer(start);
    while (!q.isEmpty()) {
      int temp = q.poll();

      for (int i = 1; i < arr.length; i++) {
        if (arr[temp][i] && !flag[i]) {
          q.offer(i);
          flag[i] = true;
          count++;
        }
      }
    }

    return count;
  }

}
