package programmerslv1;

public class ControlZ {
  public static void main(String[] args) {

    String str = "10 20 Z Z 30 40";
    System.out.println(solution(str));
    int result = 1;
  }

  public static int solution(String s) {
    int answer = 0;
    String[] arr = s.split(" ");

    int count = 0;
    if (arr[0].equals("Z")) {
      for (int i = 0; i < arr.length; i++) {
        if (!arr[i].equals("Z")) {
          break;
        }
        count++;
      }
    }

    int index = 1;
    for (int i = count; i < arr.length; i++) {
      if (!arr[i].equals("Z")) {
        answer += (int) Integer.parseInt(arr[i]);
        index = 1;
      } else {
        answer -= (int) Integer.parseInt(arr[i-index]);
        index += 2;
      }
    }

    return answer;
  }
}
