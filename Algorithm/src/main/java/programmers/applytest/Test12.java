package programmers.applytest;

public class Test12 {
  public static void main(String[] args) {

    int[] arr = new int[4];
    String s = "old man was the";
    String w = "man";
    System.out.println(solution(s, w));


  }

  static int solution(String s, String w) {

    int answer = s.indexOf(w);

    return answer;
  }
}
