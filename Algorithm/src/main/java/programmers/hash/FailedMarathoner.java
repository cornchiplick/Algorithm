package programmers.hash;

import java.util.HashMap;

public class FailedMarathoner {

  public static void main(String[] args) {
    String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] completion = {"josipa", "filipa", "marina", "nikola"};
    String result = "vinko";
    System.out.println(solution(participant, completion));

  }

  public static String solution(String[] participant, String[] completion) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String player : participant) {
      map.put(player, map.getOrDefault(player, 0) + 1);
    }
    for (String player : completion) {
      map.put(player, map.get(player) - 1);
    }

    for (String player : participant) {
      if (map.get(player).equals(1)) {
        return player;
      }
    }

    return null;

  }
}
