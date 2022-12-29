package programmers.programmerslv0;

import java.util.ArrayList;

public class OXQuiz {

  public static void main(String[] args) {
    String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
    String[] result = {"X", "O"};

    for (int i = 0; i < solution(quiz).length; i++) {
      System.out.println(solution(quiz)[i]);
    }
  }

  public static String[] solution(String[] quiz) {
    ArrayList<String> arr = new ArrayList<>();

    for (int i = 0; i < quiz.length; i++) {
      if (quiz[i].split(" ")[1].equals("-")) {
        if (Integer.parseInt(quiz[i].split(" ")[4])==Integer.parseInt(quiz[i].split(" ")[0]) -
                Integer.parseInt(quiz[i].split(" ")[2])) {
          arr.add("O");
        } else {
          arr.add("X");
        }
      } else {
        if (Integer.parseInt(quiz[i].split(" ")[4])==Integer.parseInt(quiz[i].split(" ")[0]) +
                Integer.parseInt(quiz[i].split(" ")[2])) {
          arr.add("O");
        } else {
          arr.add("X");
        }
      }
    }

    String[] answer = new String[arr.size()];

    for (int i = 0; i < arr.size(); i++) {
      answer[i] = arr.get(i);
    }
    return answer;
  }
}
