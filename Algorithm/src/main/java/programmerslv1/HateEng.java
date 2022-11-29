package programmerslv1;

public class HateEng {

  public static void main(String[] args) {
    String str = "onetwothreefourfivesixseveneightnine";
    long result = 123456789;
    System.out.println(solution(str));

  }

  public static long solution(String numbers) {
    String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    for (int i = 0; i < str.length; i++) {
      numbers = numbers.replaceAll(str[i], String.valueOf(i));
    }


    return (long) Long.valueOf(numbers);
  }
}
