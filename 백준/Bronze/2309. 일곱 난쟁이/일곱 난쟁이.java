import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static final int NUMBER_OF_DWARF = 9;

  public static void main(String[] args) {
    int[] heights = new int[NUMBER_OF_DWARF];

    Scanner sc = new Scanner(System.in);
    int diff = 0;

    // 아홉 난쟁이 키를 모두 더하고 100을 빼기 = diff
    for (int i = 0; i < NUMBER_OF_DWARF; i++) {
      heights[i] = sc.nextInt();
      diff += heights[i];
    }

    sc.close();

    diff -= 100;

    // 난쟁이 키 오름차순으로 정렬
    Arrays.sort(heights);

    // 합해서 diff가 되는 두 난쟁이 키를 찾기
    int a = 0;
    int b = 0;
    loop:
    for (int i = 0; i < heights.length - 1; i++) {
      for (int j = i + 1; j < heights.length; j++) {
        if (heights[i] + heights[j] == diff) {
          a = heights[i];
          b = heights[j];
          break loop;
        }
      }
    }

    // 그 둘을 제외한 나머지 일곱 난쟁이 키 출력
    StringBuilder sb = new StringBuilder();
    for (int height : heights) {
      if (height != a && height != b) {
        sb.append(height).append('\n');
      }
    }

    System.out.println(sb.toString());

  }
}
