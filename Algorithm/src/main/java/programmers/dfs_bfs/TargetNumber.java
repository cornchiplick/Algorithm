package programmers.dfs_bfs;

/**
 * 프로그래머스 - 깊이/너비 우선 탐색(DFS/BFS)
 * lv2 - 타겟 넘버
 * 전략
 * 1) numbers의 모든 수에 대해 빼거나 더하는 경우를 모두 체크한다.
 * 2) 만약 numbers의 모든 수에 대해 연산을 마쳤다면 그 결과가 target과 같은지 체크하고 count를 늘려준다.
 */
public class TargetNumber {
  private static int count = 0;

  public static void main(String[] args) {
    int[] numbers = {4, 1, 2, 1};
    int target = 4;
    int result = 2;
    System.out.println(solution(numbers, target));
  }

  public static int solution(int[] numbers, int target) {
    dfs(0, 0, numbers, target);
    return count;
  }

  private static void dfs(int index, int sum, int[] numbers, int target) {
    if (index == numbers.length) {
      if (sum == target) {
        count++;
      }
      return;
    }

    dfs(index + 1, sum + numbers[index], numbers, target);
    dfs(index + 1, sum - numbers[index], numbers, target);
  }
}
