import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 11053
 * 실버II - 가장 긴 증가하는 부분 수열
 * 전략
 * 1) 입력의 맨 처음부터 수열의 길이를 하나씩 늘려나간다.
 * 2) 앞에서 구한 증가하는 부분 수열들 중 원소를 하나 추가할 수 있는 경우에 모두 하나씩 추가한다.
 * 3) 그 중 가장 긴 길이를 가지는 부분수열의 길이를 구한다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    // solution
    for (int i = 0; i < n; i++) {
      dp[i] = 1;

      for (int j = 0; j < i; j++) {
        // 이번에 입력받은 수가 앞의 수보다 크다 && 이번회차까지의 수열의 길이가 이전회차까지의 수열길이의 +1 보다 작다.
        if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }

    // 그 중 최댓값 찾기
    int max = 0;
    for (int element : dp) {
      if (element > max) {
        max = element;
      }
    }

    System.out.println(max);

  }
}
