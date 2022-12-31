package baekjoon.curriculum.bruteforce;

public class FindPrime_Fail {
  public static void main(String[] args) {
    String numbers = "17";
    int result = 3;
    System.out.println(solution(numbers));

  }

  public static int solution(String numbers) {
    int count = 0;
    // 주어진 숫자 하나씩 분리
    Integer[] nums = spliceNumbers(numbers);

    Integer[] numberArr;
    for (int i = 1; i < nums.length; i++) {
      // i자리 수로 가능한 모든 수 조합
      numberArr = findNumberArr(nums, i);

      // 조합한 수가 소수인지 확인
      for (int number : numberArr) {
        if (isPrime(number)) {
          count++;
        }
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

  private static Integer[] findNumberArr(Integer[] nums, int i) {



    return new Integer[0];
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
