package programmers_hash;

import java.util.HashMap;

public class Poncketmon {
  public static void main(String[] args) {
    int[] nums = {3, 3, 3, 2, 2, 4};
    int result = 3;
    System.out.println(solution(nums));

  }

  public static int solution(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (Integer num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    if (map.size() <= nums.length/2) {
      return map.size();
    } else {
      return nums.length/2;
    }
  }
}
