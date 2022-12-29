package programmers.programmerslv0;

public class CharactersXY {

  public static void main(String[] args) {
    String[] keyinput = {"down", "down", "down", "down", "down"};
    int[] board = {7, 9};
    for (int element : solution(keyinput, board)) {
      System.out.println(element);
    }

  }

  public static int[] solution(String[] keyinput, int[] board) {
    int[] answer = {0, 0};

    for (String key : keyinput) {
      switch (key) {
        case "up":
          if (answer[1] == board[1]/2) {
            break;
          }
          answer[1]++;
          break;
        case "down":
          if (answer[1] == -board[1]/2) {
            break;
          }
          answer[1]--;
          break;
        case "left":
          if (answer[0] == -board[0]/2) {
            break;
          }
          answer[0]--;
          break;
        case "right":
          if (answer[0] == board[0]/2) {
            break;
          }
          answer[0]++;
          break;
      }

    }
    return answer;
  }
}
