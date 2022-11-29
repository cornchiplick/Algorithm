package programmerslv0;

public class StringSuSik {

  public static void main(String[] args) {
    String my_string = "3 + 4 - 2 + 3";
    int result = 7;
    System.out.println(solution(my_string));

  }

  public static int solution(String my_string) {
    String[] str = my_string.split(" ");
    int answer = Integer.parseInt(str[0]);

    for (int i = 1; i < str.length; i+=2) {
      if (str[i].equals("+")) {
        answer += Integer.parseInt(str[i + 1]);
      } else {
        answer -= Integer.parseInt(str[i + 1]);
      }
    }


    return answer;
  }
}
