package programmerslv0;

public class CursedThree {

  public static void main(String[] args) {
    System.out.println("25 == " + solution(15));
    System.out.println("76 == " + solution(40));

  }

  public static int solution(int n) {
    int answer = 0;

    for (int i = 0; i < n; i++) {
      answer++;
      while (String.valueOf(answer).contains("3") || answer%3 == 0) {
        answer++;
      }

    }

    return answer;
  }
}
