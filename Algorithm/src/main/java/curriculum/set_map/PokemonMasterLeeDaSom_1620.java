package curriculum.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * 백준 - 1260
 * 실버IV - 나는야 포켓몬 마스터 이다솜
 * 전략
 * 1) 도감번호와 포켓몬 이름을 대응시켜 저장한 후
 * 2) 임의의 입력에 대해 각각 그 대응값을 출력하면 된다.
 * 3) 입력값이 도감'번호'인지 이름('문자열')인지 확인하기 위해 정규식을 사용하였다.
 */
public class PokemonMasterLeeDaSom_1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 이름으로 번호를 저장
    HashMap<String, Integer> map = new HashMap<>();
    // 번호로 이름을 저장
    String[] arr = new String[n + 1];

    // 도감 입력
    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      map.put(name, i + 1);
      arr[i + 1] = name;
    }

    StringBuilder sb = new StringBuilder();

    // 문제 입력 및 대응값 작성
    for (int i = 0; i < m; i++) {
      String temp = br.readLine();
      if (isNumber(temp)) {
        sb.append(arr[Integer.parseInt(temp)]).append('\n');
      } else {
        sb.append(map.get(temp)).append('\n');
      }
    }
    br.close();

    System.out.println(sb);

  }

  private static boolean isNumber(String str) {
    // 숫자만을 의미하는 정규표현식
    String pattern = "^[0-9]*$";
    // 숫자라면 true, 아니면 false
    return Pattern.matches(pattern, str);
  }
}
