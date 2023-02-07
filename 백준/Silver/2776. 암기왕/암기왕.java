import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 2776
 * 실버IV - 암기왕
 * 전략
 * 1) 각각의 테스트케이스에 대해 정렬및 이분탐색을 시행한다.
 */
public class Main {
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cntCase = Integer.parseInt(br.readLine());
    int n;
    int[] arrN;
    int m;
    int[] arrM;

    // 케이스별 입력
    for (int i = 0; i < cntCase; i++) {
      n = Integer.parseInt(br.readLine());
      arrN = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arrN[j] = Integer.parseInt(st.nextToken());
      }

      m = Integer.parseInt(br.readLine());
      arrM = new int[m];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arrM[j] = Integer.parseInt(st.nextToken());
      }

      // 이분탐색
      isCorrect(arrN, arrM);
    }

    // 출력
    System.out.println(sb);
  }

  private static void isCorrect(int[] arrN, int[] arrM) {
    // 정렬
    Arrays.sort(arrN);

    // 탐색
    for (int i = 0; i < arrM.length; i++) {
      if (Arrays.binarySearch(arrN, arrM[i]) >= 0) {
        sb.append(1).append('\n');
      } else {
        sb.append(0).append('\n');
      }
    }
  }
}
