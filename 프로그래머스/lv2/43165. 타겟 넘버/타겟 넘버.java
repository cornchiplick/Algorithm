class Solution {
    private int count = 0;
  public int solution(int[] numbers, int target) {
    dfs(0, 0, numbers, target);
    return count;
  }

  private void dfs(int index, int sum, int[] numbers, int target) {
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