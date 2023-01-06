package curriculum.bruteforce;

import java.util.HashSet;
import java.util.Iterator;

public class FindPrime {
  public static HashSet<Integer> hashSet = new HashSet<>();

  public static void main(String[] args) {
    String numbers = "17";
    int result = 3;
    System.out.println(solution(numbers));

  }

  public static int solution(String numbers) {
    int count = 0;
    // 주어진 숫자 하나씩 분리
    Integer[] nums = spliceNumbers(numbers);

    // hashSet에 가능한 모든 수를 저장
    findNumberArr(0, nums);

    // hashSet에 저장된 수가 소수인지 확인
    Iterator<Integer> it = hashSet.iterator();
    while (it.hasNext()) {
      int number = it.next();

      if (isPrime(number)) {
        count++;
      }
    }

    return count;
  }

  private static Integer[] spliceNumbers(String numbers) {
    String[] str = numbers.split("");
    Integer[] nums = new Integer[str.length];
    for (int i = 0; i < str.length; i++) {
      nums[i] = Integer.parseInt(str[i]);
    }

    return nums;
  }

  private static void findNumberArr(Integer comb, Integer[] others) {
    if (comb != 0) {
      hashSet.add(comb);
    }

    for (int i = 0; i < others.length; i++) {
      if (comb != 0) {
        hashSet.add(comb);
      }

      int temp = others[i];
      if (temp != -1) {
        others[i] = -1;
        findNumberArr(comb * 10 + temp, others);
        others[i] = temp;
      }
    }

  }

  private static boolean isPrime(int number) {
    if (number == 0 || number == 1) {
      return false;
    }

    int limit = (int) Math.sqrt(number);
    for (int i = 2; i <= limit; i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

}
