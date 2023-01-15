package programmers.applytest;

public class Square {
  public static void main(String[] args) {

  }

  public static int[] solution(int[][] v) {
    int[] answer = new int[2];

    // x좌표 체크
    if (v[0][0] == v[1][0]) {
      answer[0] = v[2][0];
    } else if (v[0][0] == v[2][0]) {
      answer[0] = v[1][0];
    } else {
      answer[0] = v[0][0];
    }

    // y좌표 체크
    if (v[0][1] == v[1][1]) {
      answer[1] = v[2][1];
    } else if (v[0][1] == v[2][1]) {
      answer[1] = v[1][1];
    } else {
      answer[1] = v[0][1];
    }

    return answer;
  }
}
