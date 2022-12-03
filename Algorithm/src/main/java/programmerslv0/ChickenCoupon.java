package programmerslv0;

public class ChickenCoupon {

  public static void main(String[] args) {
    int chicken1 = 100;
    int result1 = 11;
    System.out.println("1번 예시: " + solution(chicken1));


    int chicken2 = 1081;
    int result2 = 120;
    System.out.println("2번 예시: " + solution(chicken2));

  }

  public static int solution(int chicken) {
    int answer = 0;

    while (chicken >= 10) {
      answer += chicken/10;
      chicken = chicken/10 + chicken%10;
    }

    return answer;
  }
}
