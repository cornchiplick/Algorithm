package curriculum.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 백준 - 4358
 * 실버II - 생태학
 * 전략
 * 1) map에 key/value 형태로 저장
 * 2) 저장된 key들을 사전순 정렬
 * 3) 정렬된 key들의 value와 전체 개수를 통해 백분율 계산 및 출력
 */
public class Ecology_4358 {
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

    // 사전순으로 정렬
    Object[] keys = map.keySet().toArray();
    Arrays.sort(keys);

    StringBuilder sb = new StringBuilder();
    double cal;
    for (Object key : keys) {
      cal = map.get((String) key) * 100 / wholeCount;
      // 소수점 넷째자리까지 출력
      sb.append(key).append(' ').append(String.format("%.4f", cal)).append('\n');
    }

    System.out.println(sb);

  }
}