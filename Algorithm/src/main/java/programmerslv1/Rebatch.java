package programmerslv1;

public class Rebatch {

  public static void main(String[] args) {

    int[] numbers = {1,2,3,4,5,6};
    int k = 4;
    int result = 3;
    System.out.println(solution(numbers, 3));

  }

  public static int solution(int[] numbers, int k) {
    int va = 2 * (k - 1) + 1;

    return va % (numbers.length);

  }
}
