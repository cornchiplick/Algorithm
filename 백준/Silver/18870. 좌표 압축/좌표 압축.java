import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 18870
 * 실버II - 좌표 압축
 * 전략
 * 1) 입력 받을 때, 입력값과 입력값의 순번(index)를 필드로 갖는 좌표객체로 입력받는다.
 * 2) 좌표객체의 value를 기준으로 오름차순 정렬한다.
 * 3) 만일 모두 다른 좌표값이라면 오름차순 정렬했을 때의 index가 압축좌표값이 된다.
 * 4) 그러나 조건에서 해당 좌표값보다 작은 "서로 다른" 좌표의 개수가 압축된 좌표이므로 만약 중복좌표값이 존재한다면 중복 갯수만큼 빼준다.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Coordinate[] arr = new Coordinate[Integer.parseInt(br.readLine())];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Coordinate(Integer.parseInt(st.nextToken()), i);
    }

    br.close();

    // 입력 좌표값의 오름차순으로 정렬
    Arrays.sort(arr, (o1, o2) -> {
      if (o1.value == o2.value) {
        return o1.index - o2.index;
      } else {
        return o1.value - o2.value;
      }
    });

    int[] answer = new int[arr.length];
    answer[arr[0].index] = 0;
    
    int count = 0;
    for (int i = 1; i < arr.length; i++) {
      // 중복 체크
      if (arr[i].value == arr[i - 1].value) {
        count++;
      }
      // 중복이 있다면 그 수 만큼 현재 index에서 빼준다.
      answer[arr[i].index] = i - count;
    }


    StringBuilder sb = new StringBuilder();
    for (int e : answer) {
      sb.append(e).append(" ");
    }

    System.out.println(sb);

  }

  static class Coordinate {
    int value;
    int index;

    Coordinate(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

}
