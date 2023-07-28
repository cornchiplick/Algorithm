import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static int[] visited;
  public static int count = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int nodeCnt = Integer.parseInt(st.nextToken());
    int lineCnt = Integer.parseInt(st.nextToken());
    int begin = Integer.parseInt(st.nextToken());

    visited = new int[nodeCnt+1];
    List<ArrayList<Integer>> nodes = new ArrayList<>();
    for (int i = 0; i < nodeCnt + 1; i++) {
      nodes.add(new ArrayList<Integer>());
    }
    int dot1;
    int dot2;

    for (int i = 0; i < lineCnt; i++) {
      st = new StringTokenizer(br.readLine());
      dot1 = Integer.parseInt(st.nextToken());
      dot2 = Integer.parseInt(st.nextToken());

      nodes.get(dot1).add(dot2);
      nodes.get(dot2).add(dot1);
    }

    br.close();

    for (ArrayList<Integer> element : nodes) {
      Collections.sort(element);
    }

    dfs(begin, nodes);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < visited.length; i++) {
      sb.append(visited[i]).append("\n");
    }
    System.out.print(sb);
  }

  public static void dfs(int n, List<ArrayList<Integer>> nodes) {
    visited[n] = count;
    count++;

    for (int i = 0; i < nodes.get(n).size(); i++) {
      int next = nodes.get(n).get(i);
      if (visited[next] == 0) {
        dfs(next, nodes);
      }
    }
  }
}