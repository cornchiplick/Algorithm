package curriculum.sort.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 16496
 * 플래티넘V - 가장 큰 수
 * 전략
 * 1) 숫자 두 개를 비교할 때 이어붙여본다.
 * 2) AB순서와 BA순서를 비교해서 더 큰숫자가 되는 순열에서 앞의 수가 더 큰수다
 */
public class MakingBigNumber_16496 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = new String[Integer.parseInt(br.readLine())];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = st.nextToken();
    }

    Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    if (arr[0].equals("0")) {
      System.out.println(0);
    } else {
      StringBuilder sb = new StringBuilder();
      for (String e : arr) {
        sb.append(e);
      }
      System.out.println(sb);
    }

  }
}
