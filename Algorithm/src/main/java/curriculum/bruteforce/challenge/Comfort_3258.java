package curriculum.bruteforce.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Comfort_3258 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // n, z, m 입력
    int n = Integer.parseInt(st.nextToken());
    int z = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    boolean[] obstacle = new boolean[n + 1];

    // 장애물 위치 입력
    for (int i = 0; i < m; i++) {
      obstacle[Integer.parseInt(st.nextToken())] = true;
    }

    br.close();

    System.out.println(findMinValue(n, z, obstacle));

  }

  private static int findMinValue(int n, int z, boolean[] obstacle) {
    int position;
    boolean[] obstacle2;

    loop:
    for (int i = 1; i < z; i++) {
      position = 1;
      obstacle2 = obstacle.clone();
      while (position != z) {

        // i만큼 움직인 후 위치
        position += i;
        if (position > n) {
          position -= n;
        }

        // 현위치에 장애물이 있거나 이미 한 번 지나간 위치일 경우(영원히 z에 도달할 수 없다) 다음 i
        if (!obstacle2[position]) {
          obstacle2[position] = true;
        } else {
          continue loop;
        }

      }
      // 장애물에 걸리지 않았다면 i return
      return i;
    }

    // 가능한 경우의 최댓값
    return z - 1;
  }
}
