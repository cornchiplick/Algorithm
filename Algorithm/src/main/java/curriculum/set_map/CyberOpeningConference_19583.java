package curriculum.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 - 19583
 * 실버II - 싸이버개강총회
 * 전략
 * 1) 입장인원을 파악하여 HashSet1에 담는다. (중복 방지)
 * 2) 퇴장인원을 파악한 후, 입장인원과 대조하여 HashSet2에 담는다. (중복 방지)
 * 3) HashSet2의 size가 출석인원이다.
 */
public class CyberOpeningConference_19583 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 개강총회 시작한 시간
    String start = st.nextToken();
    // 개강총회 끝난 시간
    String end = st.nextToken();
    // 개강총회 스트리밍이 끝난 시간
    String quit = st.nextToken();

    // 계속 사용할 변수 선언
    String input;
    String time;
    String name;

    // 입장 인원 확인
    HashSet<String> join = new HashSet<>();
    HashSet<String> exit = new HashSet<>();

    while ((input = br.readLine()) != null) {
      st = new StringTokenizer(input);
      time = st.nextToken();
      name = st.nextToken();

      if (start.compareTo(time) >= 0) {
        join.add(name);

        // 퇴장인원 확인 및 입장인원과 대조
      } else if (end.compareTo(time) <= 0
              && quit.compareTo(time) >= 0
              && join.contains(name)) {
        exit.add(name);
      }
    }
    br.close();

    System.out.println(exit.size());

  }
}
