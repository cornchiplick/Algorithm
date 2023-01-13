import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 11399
 * 실버IV - ATM
 * 전략
 * 1) 뽑는데 걸리는 시간의 오름차순으로 정렬을 할 것이다.
 * 2) 앞에서부터 요소를 하나씩 추가하며 부분합을 구하고 부분합들의 합을 구할 것이다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[Integer.parseInt(br.readLine())];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 정렬
    Arrays.sort(arr);
    
    // 부분합과 부분합들의 합 구하기
    int partialSum = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      partialSum += arr[i];
      sum += partialSum;
    }

    // 출력
    System.out.println(sum);
  }
}
