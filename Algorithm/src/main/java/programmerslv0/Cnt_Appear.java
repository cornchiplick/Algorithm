package programmerslv0;

public class Cnt_Appear {

  public static void main(String[] args) {
    int i = 10;
    int j = 50;
    int k = 5;
    int result = 5;
    System.out.println("result=5 ::: " + solution(i,j,k));

  }

  // i부터 j까지 k가 몇 번 등장하는지?
  public static int solution(int i, int j, int k) {
    int answer = 0;
    char v = String.valueOf(k).toCharArray()[0];
    String q;
    for (int p = i; p <= j; p++) {
      q = String.valueOf(p);
      for (int r = 0; r < q.length(); r++) {
        if (q.charAt(r)==v) {
          answer++;
        }
      }
    }

    return answer;
  }
}
