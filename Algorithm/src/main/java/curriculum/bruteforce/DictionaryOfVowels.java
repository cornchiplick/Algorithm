package curriculum.bruteforce;

public class DictionaryOfVowels {
  public static int result = 0;
  public static boolean isEqual = false;

  public static void main(String[] args) {
    String word = "I";
    int result = 1563;
    System.out.println(solution(word));
  }

  public static int solution(String word) {
    recursive(word, new StringBuilder(), new String[]{"A", "E", "I", "O", "U"});
    return result;
  }

  public static void recursive(String word, StringBuilder sb, String[] sArray) {
    if (word.equals(sb.toString())) {
      isEqual = true;
      return;
    }

    if (sb.length() == 5) {
      return;
    }

    for (int i = 0; i < sArray.length; i++) {
      // (길이 4이하인)sb에 i번째 문자 추가
      sb.append(sArray[i]);
      // 카운트 하나 추가
      result++;
      // 길이가 4였다면 아무일도 일어나지 않고, 더 짧았다면 문자와 카운트가 하나 추가된다.
      recursive(word, sb, sArray);

      // 그러고나서도 같은지 확인
      if (isEqual) {
        return;
      }

      // 마지막 문자를 교체하기 위해 뒤에서 하나 제거한다.
      sb.delete(sb.length() - 1, sb.length());
    }

  }
}
