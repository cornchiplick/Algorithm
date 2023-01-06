package curriculum.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberSort2_2751 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[Integer.parseInt(br.readLine())];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    br.close();

    Arrays.sort(arr);

    StringBuilder sb = new StringBuilder();
    for (int e : arr) {
      sb.append(e).append('\n');
    }
    System.out.println(sb);

  }
}
