import java.util.*;
class Solution {
  public int solution(int[] citations) {
    Arrays.sort(citations);

    int count = 0;
    for (int i = citations.length - 1, j = 1; i >= 0; i--, j++) {
      if (citations[i] < j) {
        break;
      }
      count++;
    }

    return count;
  }
}