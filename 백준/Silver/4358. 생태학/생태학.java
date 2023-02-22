import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 백준 - 4358
 * 실버II - 생태학
 * 전략
 * 1) ㅇㅇ
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // map에 종과 개수 담기
    HashMap<String, Integer> map = new HashMap<>();
    double wholeCount = 0;

    String temp;
    while ((temp = br.readLine()) != null) {
      map.put(temp, map.getOrDefault(temp, 0) + 1);
      wholeCount++;
    }
    br.close();

    Object[] keys = map.keySet().toArray();
    Arrays.sort(keys);

    StringBuilder sb = new StringBuilder();
    double cal;
    for (Object key : keys) {
      cal = map.get((String) key) * 100 / wholeCount;
      sb.append(key).append(' ').append(String.format("%.4f", cal)).append('\n');
    }

    System.out.println(sb);

  }
}
