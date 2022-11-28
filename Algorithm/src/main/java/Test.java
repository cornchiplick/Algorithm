import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {

    System.out.println(solution("ab3d9"));

  }

  public static int solution(String my_string) {
    int answer = 0;
    ArrayList arr = new ArrayList();
    StringBuilder sb = new StringBuilder();

    int count = -1;
    for (int i = 0; i < my_string.length(); i++) {
      if (Character.isDigit(my_string.charAt(i))) {
        count = i;
      }
    }
    if (count == -1) {
      return 0;
    }

    for (int i = count; i < my_string.length(); i++) {
      if (Character.isDigit(my_string.charAt(i))) {
        sb.append(my_string.charAt(i));
      } else if (i == my_string.length()-1) {
          if (Character.isDigit(my_string.charAt(i))) {
            arr.add(Integer.parseInt(sb.toString()));
            break;
          }
      } else {
        arr.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);
      }
    }



    return answer;
  }
}
