package curriculum.stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 - 10025
 * 실버III - 게으른 백곰
 * 전략
 * 1) Two Pointer 알고리즘 사용
 * 2) 양동이들의 양과 위치가 담긴 배열을 이용
 * 3) 주어진 조건 내에서 얼음의 부분합이 최대가 되는 얼음의 양을 출력한다.
 */
public class LazyPolarBear_10025 {

  // 얼음 최대량
  public static int max = 0;

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Ice[] arr = new Ice[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new Ice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // arr을 position 오름차순으로 정렬한다.
    Arrays.sort(arr, Comparator.comparingInt(o -> o.position));

    // 계산
    calculate(arr, k);

    // 출력
    System.out.println(max);

  }

  private static void calculate(Ice[] arr, int k) {
    int start = 0;
    int end = 0;
    int sum = arr[0].amount;

    // 부분합이 최대가 될 때까지 반복한다.
    while (start < arr.length) {
      if (arr[end].position - arr[start].position <= 2 * k) {
        max = Math.max(max, sum);

        // end가 arr길이보다 작다면 계속 값을 늘려준다.
        if (end != arr.length - 1) {
          sum += arr[++end].amount;
        } else {
          // 최대치에 도달하면 break;
          break;
        }
      } else {
        sum -= arr[start++].amount;
      }
    }

  }

  static class Ice {
    Integer amount;
    Integer position;

    Ice(Integer amount, Integer position) {
      this.amount = amount;
      this.position = position;
    }
  }
}
