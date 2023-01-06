package curriculum.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BokMyunSan_15811_Fail {
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
    String first = st.nextToken();
    String second = st.nextToken();
    String third = st.nextToken();

    // 0부터 9까지 숫자 세팅
    int[] num = new int[10];
    for (int i = 0; i < num.length; i++) {
      num[i] = i;
    }

    HashMap<Character, Integer> map = new HashMap<>();

    // s e n d m o r y
    // 0 1 2 3 4 5 6 7 8 9

  }
}
