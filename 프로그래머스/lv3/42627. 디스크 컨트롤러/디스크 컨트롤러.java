import java.util.*;

class Solution {
public int solution(int[][] jobs) {
    int answer = 0;
    Arrays.sort(jobs, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      } else {
        return o1[0] - o2[0];
      }
    });

    PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    int count = 0;
    int i = 0;
    int now = 0;
    while (count < jobs.length) {
      while (i < jobs.length && jobs[i][0] <= now) {
        q.offer(jobs[i]);
        i++;
      }

      if (q.isEmpty()) {
        now = jobs[i][0];
      } else {
        int[] temp = q.poll();
        // 이 작업에 걸린 시간 = 현재시간 + 걸린시간 - 요청시간
        answer += now + temp[1] - temp[0];
        now += temp[1];
        count++;
      }
    }

    return answer / jobs.length;
  }
}