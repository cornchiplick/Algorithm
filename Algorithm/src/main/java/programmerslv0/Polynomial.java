package programmerslv0;

public class Polynomial {

  public static void main(String[] args) {
    String polynomial = "3x + 7 + x";
    String result = "4x + 7";
    System.out.println(solution(polynomial));

  }

  public static String solution(String polynomial) {
    int[] varAndConst = new int[2];

    String[] str = polynomial.split(" \\+ ");

    for (String element : str) {
      if (!element.contains("x")) {
        varAndConst[1] += Integer.parseInt(element);
      } else {
        if (element.equals("x")) {
          varAndConst[0]++;
        } else {
          varAndConst[0] += Integer.parseInt(element.substring(0,element.length()-1));
        }
      }
    }
    String answer;
    if (varAndConst[0] == 1) {
      answer = "x + " + varAndConst[1];
    } else {
      answer = varAndConst[0] + "x + " + varAndConst[1];
    }

    if (varAndConst[0] == 0) {
      answer = String.valueOf(varAndConst[1]);
    }
    if (varAndConst[1] == 0) {
      if (varAndConst[0] != 1) {
        answer = String.valueOf(varAndConst[0]) + "x";
      } else {
        answer = "x";
      }
    }
    if (varAndConst[0] == 0 && varAndConst[1] == 0) {
      answer = "0";
    }
    return answer;
  }
}
