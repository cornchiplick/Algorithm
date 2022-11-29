package programmerslv0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Josephus {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    LinkedList<Integer> josep = new LinkedList<Integer>();
    for (int i = 1; i <= N; i++) {
      josep.add(i);
    }

    sb.append("<");
    int cursor = K-1;

    while (!josep.isEmpty()) {
      sb.append(josep.get(cursor));
      sb.append(",");
      sb.append(" ");
      josep.remove(cursor);
      for (int i = 0; i < K; i++) {
        cursor++;
        if (cursor == josep.size()) {
          cursor = 0;
        }
      }
    }

  }
}
