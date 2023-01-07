package curriculum.sort.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 1517 - Fail(시간초과)
 * 플래티넘V - 버블 소트
 * 참고 : https://velog.io/@solser12/%EB%B0%B1%EC%A4%80-1517-%EB%B2%84%EB%B8%94-%EC%86%8C%ED%8A%B8-JAVA
 */
public class BubbleSort_1517_Fail {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[Integer.parseInt(br.readLine())];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(bubbleSortAndCount(arr));

  }


  private static int bubbleSortAndCount(int[] arr) {
    if (arr.length == 1) {
      return 0;
    }

    int count = 0;
    int temp;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          count++;
        }
      }
    }

    return count;
  }
}
