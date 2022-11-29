package programmerslv0;

public class NextNumber {

  public static void main(String[] args) {
    int[] common = {1, 2, 3, 4};
    int result = 5;
    System.out.println(solution(common));

  }

  public static int solution(int[] common) {
    int answer = 0;

    if (common[0]+common[common.length-1] == common[1]+common[common.length-2]) {
      answer = common[common.length-1] + common[1]-common[0];
    } else {
      answer = common[common.length-1] * common[1] / common[0];
    }

    return answer;
  }
}
