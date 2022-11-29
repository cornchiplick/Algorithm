package programmerslv0;

import java.util.ArrayList;

public class HiddenNumSum {
  public static void main(String[] args) {

    System.out.println(solution("aAb1B2cC34oOp"));

  }

  public static int solution(String my_string) {
    int answer = 0;
    ArrayList arr = new ArrayList();
    StringBuilder sb = new StringBuilder();

    int count = -1;
    for (int i = 0; i < my_string.length(); i++) {
      if (Character.isDigit(my_string.charAt(i))) {
        count = i;
        break;
      }
    }

    if (count == -1) {
      return 0;
    }

    for (int i = count; i < my_string.length(); i++) {
      if (Character.isDigit(my_string.charAt(i))) {
        sb.append(my_string.charAt(i));
        if (i == my_string.length()-1 && (sb.length() != 0)) {
          arr.add(Integer.parseInt(sb.toString()));
        }

      } else if (sb.length() != 0) {
        arr.add(Integer.parseInt(sb.toString()));
        sb.setLength(0);
      }
    }

    for (int i = 0; i < arr.size(); i++) {
      answer += (int) arr.get(i);
    }



    return answer;
  }
}
